package com.heyoufu.authserver.controller;

import com.heyoufu.pay.common.vo.auth.AccessTokenVO;
import com.heyoufu.pay.common.vo.auth.FormLoginUserVO;
import com.heyoufu.pay.common.vo.auth.SmsLoginUserVO;
import com.heyoufu.authserver.service.LoginService;
import com.heyoufu.pay.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * xzm 2020-5-18
 */
@Api(tags = "登录模块")
@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "表单登录", httpMethod = "POST")
    @PostMapping("/form")
    public CommonResult<AccessTokenVO> formLogin(FormLoginUserVO user) throws Exception {
        return CommonResult.success("登录成功", loginService.formLogin(user));
    }

    @ApiOperation(value = "获取登录的短信验证码", httpMethod = "GET")
    @GetMapping("/sms/code/{mobile}")
    public CommonResult<String> smsCode(@PathVariable String mobile) throws Exception {
        return CommonResult.success("短信发送成功", loginService.smsCode(mobile));
    }

    @ApiOperation(value = "短信验证码登录", httpMethod = "POST")
    @PostMapping("/sms")
    public CommonResult<AccessTokenVO> smsLogin(SmsLoginUserVO user, HttpServletRequest request) throws Exception {
        return CommonResult.success("登录成功", loginService.smsLogin(user));
    }
}