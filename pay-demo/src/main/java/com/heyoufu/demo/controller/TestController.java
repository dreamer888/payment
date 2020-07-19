package com.heyoufu.demo.controller;



import com.heyoufu.demo.feign.PayAgentFeign;
import com.heyoufu.demo.feign.PayAuthServerFeign;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.heyoufu.demo.service.*;


import java.util.List;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/demo")
@CrossOrigin
public class TestController {

    @Autowired
    private PayAuthServerFeign payAuthServerFeign;

    @Autowired
    private PayAgentFeign payAgentFeign;

    @Autowired
    private SystemServiceService systemServiceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value = "oauth2权限测试", httpMethod = "GET")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/auth_test")
    public String authTest() {
        return "success";
    }

    @ApiOperation(value = "跨服务调用测试", httpMethod = "GET")
    @RequestMapping(value = "/fegin_test", method = RequestMethod.GET)
    public CommonResult feginTest() {
        return payAuthServerFeign.test();
    }

    @ApiOperation(value = "跨服务调用测试-pay-agent", httpMethod = "GET")
    @RequestMapping(value = "/agent_fegin_test", method = RequestMethod.GET)
    public String agentFeginTest() {
        return payAgentFeign.test();
    }

    @ApiOperation(value = "数据库访问测试", httpMethod = "GET")
    @RequestMapping(value = "/db_test", method = RequestMethod.GET)
    public CommonResult<List<SystemService>> dbTest() {
        return CommonResult.success(systemServiceService.findAll());
    }

}
