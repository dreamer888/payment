package com.heyoufu.merchant.controller.app;

import com.heyoufu.merchant.service.PaymentOrderService;
import com.heyoufu.merchant.vo.dtoVO.AppPaymentOrderDtoVO;
import com.heyoufu.merchant.vo.dtoVO.FindTimeByAppListDto;
import com.heyoufu.merchant.vo.searchVO.OrderBillSearchVO;
import com.heyoufu.pay.common.api.CommonResult;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.OrderTimeSerchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: xuanX
 * 3 * @Date: 2020/6/9 9:27
 * 4
 */
@Api(tags = "app商户订单模块")
@RestController
@RequestMapping("/app/order")
public class AppOrderController {

    @Autowired
    private PaymentOrderService paymentOrderService;

    @ApiOperation(value = "xuan：根据时间段查询商户订单",httpMethod = "POST")
    @PostMapping(value = "/getPoNoTimeOrder")
    public CommonResult<AppPaymentOrderDtoVO> getPoNoTimeOrder (@RequestBody OrderTimeSerchVo vo) {
        return CommonResult.success(paymentOrderService.getPoNoTimeOrder(vo));
    }

    @ApiOperation(value ="xuan：app查询统计该月商户订单",httpMethod ="POST")
    @PostMapping("/findTimeByAppList")
    public CommonResult<List<FindTimeByAppListDto>> findTimeByAppList(@RequestBody OrderBillSearchVO orderBillSearchVo){
        return CommonResult.success(paymentOrderService.findTimeByAppList(orderBillSearchVo));
    }

}
