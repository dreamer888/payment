package com.heyoufu.authserver.controller;

import com.heyoufu.authserver.service.RegisterService;
import com.heyoufu.pay.common.vo.auth.RegisterUserVO;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.util.Generator;
import com.heyoufu.pay.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "注册模块")
@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "校验用户名", httpMethod = "GET")
    @GetMapping("/checkUsername/{username}")
    public CommonResult checkUsername(@PathVariable String username) throws Exception {
        registerService.checkUsername(username);
        return CommonResult.success("校验通过");
    }

    @ApiOperation(value = "校验邮箱", httpMethod = "GET")
    @GetMapping("/checkEmail/{mail}")
    public CommonResult checkEmail(@PathVariable String mail) throws Exception {
        registerService.checkEmail(mail);
        return CommonResult.success("校验通过");
    }

    @ApiOperation(value = "校验手机号", httpMethod = "GET")
    @GetMapping("/checkPhone/{phone}")
    public CommonResult checkPhone(@PathVariable String phone) throws Exception {
        registerService.checkPhone(phone);
        return CommonResult.success("校验通过");
    }

    @ApiOperation(value = "获取注册的短信验证码", httpMethod = "GET")
    @GetMapping("/sms/code/{phone}")
    public CommonResult smsCode(@PathVariable String phone) throws Exception {
        return CommonResult.success("短信发送成功", registerService.smsCode(phone));
    }

    @ApiOperation(value = "用户注册", httpMethod = "POST")
    @PostMapping("/do")
    public CommonResult doRegister(RegisterUserVO registerUserVO) throws Exception {
        return CommonResult.success(registerService.doRegister(registerUserVO));
    }

    @ApiOperation(value = "test", httpMethod = "GET")
    @GetMapping("/test")
    public CommonResult test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Generator.getId());
        userInfo.setUsername("xzm_test");
        return CommonResult.success(userInfo);
    }

}