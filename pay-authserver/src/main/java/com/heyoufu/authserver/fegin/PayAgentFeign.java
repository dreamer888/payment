package com.heyoufu.authserver.fegin;

import com.alibaba.fastjson.JSONObject;
import com.heyoufu.authserver.fegin.fallback.PayAgentFeignFallback;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "pay-agent", fallback = PayAgentFeignFallback.class)
public interface PayAgentFeign {

    @ApiOperation(value = "二维码用户绑定",httpMethod = "POST")
    @PostMapping("/agent/qrcode/addUserInfoBound")
    public CommonResult qrcodeUserInfoBound(@RequestParam String qrcodeNo, @RequestBody UserInfo userInfo);

    @ApiOperation(value = "二维码代理商用户绑定",httpMethod = "POST")
    @PostMapping("/agent/qrcode/addAgentUserInfoBound")
    public CommonResult addAgentUserInfo(@RequestParam String agentNo,@RequestParam String merchantNo);
}
