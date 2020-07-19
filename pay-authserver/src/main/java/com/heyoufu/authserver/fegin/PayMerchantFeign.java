package com.heyoufu.authserver.fegin;

import com.heyoufu.authserver.fegin.fallback.PayMerchantFeignFallback;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.model.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "pay-merchant", fallback = PayMerchantFeignFallback.class)
public interface PayMerchantFeign {

    @ApiOperation(value = "保存商户", httpMethod = "POST")
    @PostMapping("/merchant/saveMercant")
    public CommonResult<Integer> saveMercant (@RequestBody MerchantReviewSystemSerchVO vo);

    @ApiOperation(value = "添加默认商户", httpMethod = "POST")
    @PostMapping("/merchant/setDefaultMerchantReview")
    public CommonResult<String> setDefaultMerchantReview (@RequestBody UserInfo vo);
}