package com.heyoufu.authserver.fegin.fallback;

import com.heyoufu.authserver.fegin.PayMerchantFeign;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.model.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class PayMerchantFeignFallback implements PayMerchantFeign {

    @Override
    public CommonResult<Integer> saveMercant(MerchantReviewSystemSerchVO vo) {
        throw new RuntimeException("商户服务调用异常");
    }

    @Override
    public CommonResult<String> setDefaultMerchantReview(UserInfo vo) {
        throw new RuntimeException("商户服务调用异常");
    }
}
