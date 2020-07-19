package com.heyoufu.authserver.controller;

import com.heyoufu.authserver.service.SystemServiceService;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "系统服务模块")
@RestController
@CrossOrigin
@RequestMapping("/sys/service")
public class SystemServiceController {

    @Autowired
    private SystemServiceService systemServiceService;

    @ApiOperation(value = "新增系统服务", httpMethod = "POST")
    @PostMapping("/create")
    public CommonResult<SystemService> create(SystemService systemService) throws Exception {
        return CommonResult.success(systemServiceService.create(systemService));
    }

    @ApiOperation(value = "查询全部系统服务", httpMethod = "GET")
    @GetMapping("/findAll")
    public CommonResult<List<SystemService>> findAll() {
        return CommonResult.success(systemServiceService.findAll());
    }

}
