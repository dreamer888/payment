package com.heyoufu.demo.feign;

import com.heyoufu.demo.feign.fallback.PayAgentFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "pay-agent", fallback = PayAgentFeignFallback.class)
public interface PayAgentFeign {

    @GetMapping("/agent/test")
    String     test();

}
