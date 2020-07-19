package com.heyoufu.merchant.controller;

import com.heyoufu.merchant.service.MercantService;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.MerchantReviewSystemSerchVO;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/4 11:03
 * 4
 */

@Api(tags = "商户模块")
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MercantService mercantService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


//    @PreAuthorize("hasRole('ROLE_USER')")

    @ApiOperation(value = "添加默认商户", httpMethod = "POST")
    @PostMapping("/setDefaultMerchantReview")
    public CommonResult<String> setDefaultMerchantReview (@RequestBody UserInfo vo) {
        return CommonResult.success("添加成功", mercantService.setDefaultMerchantReview(vo));
    }

    @ApiOperation(value = "保存商户", httpMethod = "POST")
    @PostMapping("/saveMercant")
    public CommonResult<Integer> saveMercant (@RequestBody MerchantReviewSystemSerchVO vo) {

        return CommonResult.success(mercantService.saveMercant(vo));
    }

}
