package com.heyoufu.authserver.controller;

import com.heyoufu.authserver.service.RoleInfoService;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.RoleInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色模块")
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleInfoService roleInfoService;

    @ApiOperation(value = "新建角色", httpMethod = "POST")
    @PostMapping("/create")
    public CommonResult create(RoleInfo roleInfo) throws Exception{
        return CommonResult.success(roleInfoService.create(roleInfo));
    }

    @ApiOperation(value = "查询所有角色信息", httpMethod = "GET")
    @GetMapping("/findAll")
    public CommonResult findAll() throws Exception{
        return CommonResult.success(roleInfoService.findAll());
    }

}