package com.heyoufu.authserver.fegin.fallback;

import com.heyoufu.authserver.fegin.PayAgentFeign;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class PayAgentFeignFallback implements PayAgentFeign {




    @Override
    public CommonResult qrcodeUserInfoBound(String qrcodeNo, UserInfo userInfo) {
        throw new RuntimeException("代理商服务调用异常");
    }

    @Override
    public CommonResult addAgentUserInfo(String agentNo, String merchantNo) {
        throw new RuntimeException("代理商服务调用异常");
    }
}
