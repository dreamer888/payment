package com.heyoufu.demo.feign.fallback;

import com.heyoufu.demo.feign.PayAgentFeign;
import org.springframework.stereotype.Component;

@Component
public class PayAgentFeignFallback implements PayAgentFeign {
    @Override
    public String test()
    {
        return "跨服务调用失败！";
    }
}
