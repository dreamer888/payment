package com.heyoufu.authserver.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.heyoufu.authserver.fegin.PayAgentFeign;
import com.heyoufu.authserver.fegin.PayMerchantFeign;
import com.heyoufu.authserver.service.RegisterService;
import com.heyoufu.authserver.service.UserInfoService;
import com.heyoufu.authserver.service.UserServiceService;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.api.ResultCode;
import com.heyoufu.pay.common.constant.SysRoleConstant;
import com.heyoufu.pay.common.vo.auth.RegisterUserVO;
import com.heyoufu.pay.common.constant.Constants;
import com.heyoufu.pay.common.constant.RedisConstant;
import com.heyoufu.pay.common.constant.SysUserServiceConstant;
import com.heyoufu.pay.common.util.RegexUtil;
import com.heyoufu.pay.common.util.SmsUtil;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.mapper.UserRoleMapper;
import com.heyoufu.pay.model.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserServiceService userServiceService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PayMerchantFeign payMerchantFeign;

    @Autowired
    private PayAgentFeign payAgentFeign;

    @Override
    public void checkUsername(String username) throws Exception{
        if (StrUtil.isBlank(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo != null) {
            throw new RuntimeException("该用户名已存在");
        }
        if (username.length() <= 6) {
            throw new RuntimeException("用户名不得少于6位数");
        }
        if (RegexUtil.isAllNumber(username)) {
            throw new RuntimeException("用户名不能全部为数字");
        }
        if (RegexUtil.isAllLetter(username)) {
            throw new RuntimeException("用户名不能全部为字母");
        }
    }

    @Override
    public void checkEmail(String mail) throws Exception {
        if (StrUtil.isBlank(mail)) {
            throw new RuntimeException("电子邮箱不能为空");
        }
        UserInfo userInfo = userInfoService.findByMail(mail);
        if (userInfo != null) {
            throw new RuntimeException("该邮箱已存在");
        }
        if (!RegexUtil.checkEmail(mail)) {
            throw new RuntimeException("邮箱地址格式不正确");
        }
    }

    @Override
    public void checkPhone(String phone) throws Exception {
        if (StrUtil.isBlank(phone)) {
            throw new RuntimeException("手机号不能为空");
        }
        UserInfo userInfo = userInfoService.findByPhone(phone);
        if (userInfo != null) {
            throw new RuntimeException("该手机号码已存在");
        }
        if (!RegexUtil.checkPhone(phone)) {
            throw new RuntimeException("手机号码格式不正确");
        }
    }

    @Override
    public String smsCode(String phone) throws Exception {
        String code = SmsUtil.createCode();
        SmsUtil.send(phone, code);
        String key = RedisConstant.SMS_REGISTER_CODE + phone;
        redisTemplate.opsForValue().set(key, code, 1, TimeUnit.MINUTES);
        return code;
    }

    @Transactional
    @Override
    public String doRegister(RegisterUserVO registerUserVO) throws Exception {
        /** 1.校验并保存用户数据 */
        checkUsername(registerUserVO.getUsername());
        String password = registerUserVO.getPassword();
        if (StrUtil.isBlank(password)) {
            throw new RuntimeException("密码不能为空");
        }
        String rPassword = registerUserVO.getRPassword();
        if (!password.equals(rPassword)) {
            throw new RuntimeException("确认密码与密码不一致");
        }
        checkEmail(registerUserVO.getMail());
        String phone = registerUserVO.getPhone();
        checkPhone(phone);
//        String redisCode = redisTemplate.opsForValue().get(RedisConstant.SMS_REGISTER_CODE + phone);
//        if (redisCode == null) {
//            throw new RuntimeException("验证码已过期");
//        } else if (!redisCode.equals(registerUserVO.getCheckCode())) {
//            throw new RuntimeException("验证码错误");
//        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(registerUserVO, userInfo);
        userInfo.setStatus(Constants.USER_STATUS_NORMAL);
        userInfo.setMailStatus(true);
        userInfo.setPhoneStatus(true);
        userInfo = userInfoService.add(userInfo);
        /** 2. 分配角色-默认用户 */
        UserRole userRole = new UserRole();
        userRole.setUserId(userInfo.getId());
        userRole.setRoleId(SysRoleConstant.ROLE_USER);
        userRoleMapper.insertSelective(userRole);
        /** 3. 创建默认的商户审核信息 */
        userInfo.setCreateTime(null);
        userInfo.setUpdateTime(null);
        CommonResult<String> integerCommonResult = payMerchantFeign.setDefaultMerchantReview(userInfo);
        if (integerCommonResult.getCode() == ResultCode.FAILED.getCode()) throw new RuntimeException(integerCommonResult.getMessage());
        String merchatnNo = integerCommonResult.getData();
        /** 4. 判断是否通过二维码注册 */
        String qrCode = registerUserVO.getQrCode();
        if (StrUtil.isNotBlank(qrCode)) {
            String qrcodeNo = new String(Base64.decodeBase64(qrCode));
            payAgentFeign.qrcodeUserInfoBound(qrcodeNo, userInfo);
            String age = registerUserVO.getAge();
            if (StrUtil.isNotBlank(age)) {
                String agentNo = new String(Base64.decodeBase64(age));
                payAgentFeign.addAgentUserInfo(agentNo, merchatnNo);
            }
        }
        /** 5. 判断是否通过代理商注册 */
        if (StrUtil.isNotBlank(registerUserVO.getInvitationCode())) {
            CommonResult commonResult = payAgentFeign.addAgentUserInfo(registerUserVO.getInvitationCode(), merchatnNo);
            if (commonResult.getCode() == ResultCode.FAILED.getCode()) throw new RuntimeException(commonResult.getMessage());
        }
        /** 6. 开通用户服务-短信提醒服务 */
        UserService userService = new UserService();
        userService.setUserId(userInfo.getId());
        userService.setServiceId(SysUserServiceConstant.SHORT_MESSAGE_ALERT_ID);
        userServiceService.create(userService);
        return "注册成功";
    }

    public static void main(String[] args) {
        System.out.println(new String(Base64.encodeBase64("A16645617291073186560".getBytes())));
    }

}