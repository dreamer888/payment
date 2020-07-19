package com.heyoufu.agent.controller;

import com.heyoufu.agent.service.QrcodeService;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xnk
 * @data 2020/6/4 11:02
 */
@Api(tags = "二维码设置中心")
@RestController
@RequestMapping("/agent/qrcode")
public class OrcodeSettingController {

    @Resource
    private QrcodeService qrcodeService;

    @ApiOperation(value = "二维码用户绑定",httpMethod = "POST")
    @PostMapping("/addUserInfoBound")
    public CommonResult qrcodeUserInfoBound(@RequestParam String qrcodeNo,@RequestBody UserInfo userInfo) {
        return CommonResult.success(qrcodeService.addQrcode(qrcodeNo,userInfo));
    }

    @ApiOperation(value = "二维码代理商用户绑定",httpMethod = "POST")
    @PostMapping("/addAgentUserInfoBound")
    public CommonResult addAgentUserInfo(@RequestParam String agentNo,@RequestParam String merchantNo){
        return CommonResult.success(qrcodeService.addAgentUserInfo(agentNo ,merchantNo));
    }
}
