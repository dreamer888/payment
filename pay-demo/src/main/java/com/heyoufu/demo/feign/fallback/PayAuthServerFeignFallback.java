package com.heyoufu.demo.feign.fallback;

import com.heyoufu.demo.feign.PayAuthServerFeign;
import com.heyoufu.pay.common.api.CommonResult;
import org.springframework.stereotype.Component;

/**
 * 用户服务熔断降级处理
 */
@Component
public class PayAuthServerFeignFallback implements PayAuthServerFeign {

    @Override
    public CommonResult test() {
        return CommonResult.failed("pay-auth-server没有启动");
    }
}
