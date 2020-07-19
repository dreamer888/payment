package com.heyoufu.authserver.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.heyoufu.pay.common.vo.auth.AccessTokenVO;
import com.heyoufu.pay.common.vo.auth.FormLoginUserVO;
import com.heyoufu.pay.common.vo.auth.SmsLoginUserVO;
import com.heyoufu.authserver.service.LoginService;
import com.heyoufu.authserver.service.UserInfoService;
import com.heyoufu.pay.common.constant.RedisConstant;
import com.heyoufu.pay.common.util.SmsUtil;
import com.heyoufu.pay.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * xzm 2020-5-18
 * 登录service
 */
@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    private static final String OAUTH_TOKEN_URL = "http://HOST:PORT/oauth/token";

    private static final String PASSWORD_GRANT_TYPE = "password";

    private static final String SCOPE = "all";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userAccountService;

    @Override
    public AccessTokenVO formLogin(FormLoginUserVO user) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());
        params.put("grant_type", PASSWORD_GRANT_TYPE);
        params.put("scope", SCOPE);
        params.put("client_id", user.getClient_id());
        params.put("client_secret", user.getClient_secret());
        String post = HttpUtil.post(OAUTH_TOKEN_URL.replace("HOST", host).replace("PORT", port), params);
        AccessTokenVO token = JSONUtil.toBean(post, AccessTokenVO.class);
        if (token.getAccess_token() == null) {
            JSONObject err = JSONUtil.toBean(post, JSONObject.class);
            String error_description = err.getStr("error_description");
            throw new RuntimeException(error_description);
        }
        return token;
    }

    @Override
    public String smsCode(String mobile) throws Exception {
        UserInfo account = userAccountService.findByPhone(mobile);
        if (account == null) {
            throw new RuntimeException("当前手机号未在系统注册, 不能发送");
        }
        String code = SmsUtil.createCode();
        SmsUtil.send(mobile, code);
        String key = RedisConstant.SMS_LOGIN_CODE + mobile;
        redisTemplate.opsForValue().set(key, code, 1, TimeUnit.MINUTES);
        return code;
    }

    @Override
    public AccessTokenVO smsLogin(SmsLoginUserVO user) throws Exception {
        String smsCode = user.getSmsCode();
        String key = RedisConstant.SMS_LOGIN_CODE + user.getMobile();
        String redisCode = redisTemplate.opsForValue().get(key);
        if (redisCode == null) {
            throw new RuntimeException("验证码无效");
        }
        if (!redisCode.equals(smsCode)) {
            throw new RuntimeException("验证码错误");
        }
        FormLoginUserVO formLoginUser = new FormLoginUserVO();
        formLoginUser.setUsername(user.getMobile());
        formLoginUser.setPassword(smsCode);
        formLoginUser.setClient_id(user.getClient_id());
        formLoginUser.setClient_secret(user.getClient_secret());
        return formLogin(formLoginUser);
    }
}
