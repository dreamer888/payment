package com.heyoufu.merchant.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/demo")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value = "oauth2权限测试", httpMethod = "GET")
//    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/auth_test")
    public String authTest() {
        return "success";
    }

}