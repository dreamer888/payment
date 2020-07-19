package com.heyoufu.demo.feign;

import com.heyoufu.demo.feign.fallback.PayAuthServerFeignFallback;
import com.heyoufu.pay.common.api.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "pay-auth-server", fallback = PayAuthServerFeignFallback.class)
public interface PayAuthServerFeign {

    @ApiOperation(value = "test", httpMethod = "GET")
    @GetMapping("/register/test")
    public CommonResult test();

}
