package com.heyoufu.merchant.controller.web;

import com.github.pagehelper.PageInfo;
import com.heyoufu.merchant.service.PaymentOrderService;
import com.heyoufu.merchant.vo.dtoVO.ChildrenVO;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.payOrderSerchVO;
import com.heyoufu.pay.model.PaymentOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/9 9:25
 * 4
 */
@Api(tags = "web商户订单模块")
@RestController
@RequestMapping("/web/order")
public class WebOrderController {

    @Autowired
    private PaymentOrderService paymentOrderService;

    //    @PreAuthorize("hasRole('ROLE_USER')")

    @ApiOperation(value = "订单列表", httpMethod = "GET")
    @GetMapping("/list")
    public CommonResult<PageInfo<PaymentOrder>> list (@RequestBody payOrderSerchVO vo) {
        return CommonResult.success(paymentOrderService.list(vo));
    }

    @ApiOperation(value = "xuan：获取慧收钱支付方式", httpMethod = "GET")
    @GetMapping("/getHsqList")
    public CommonResult<List<ChildrenVO>> getHsqList() {
        return CommonResult.success(paymentOrderService.getHsqList());
    }

    @ApiOperation(value = "xuan：获取慧收钱订单类型", httpMethod = "GET")
    @GetMapping("/getHsqStatusList")
    public CommonResult<List<ChildrenVO>> getHsqStatusList() {
        return CommonResult.success(paymentOrderService.getHsqStatusList());
    }


}
