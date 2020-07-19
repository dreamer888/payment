package com.heyoufu.merchant.service;

import com.github.pagehelper.PageInfo;
import com.heyoufu.merchant.vo.dtoVO.AppPaymentOrderDtoVO;
import com.heyoufu.merchant.vo.dtoVO.ChildrenVO;
import com.heyoufu.merchant.vo.dtoVO.FindTimeByAppListDto;
import com.heyoufu.merchant.vo.searchVO.OrderBillSearchVO;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.OrderTimeSerchVo;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.payOrderSerchVO;
import com.heyoufu.pay.model.PaymentOrder;

import java.util.List;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/9 9:34
 * 4
 */
public interface PaymentOrderService {

    PageInfo<PaymentOrder> list(payOrderSerchVO vo);

    AppPaymentOrderDtoVO getPoNoTimeOrder(OrderTimeSerchVo vo);

    List<FindTimeByAppListDto> findTimeByAppList(OrderBillSearchVO orderBillSearchVo);

    List<ChildrenVO> getHsqStatusList();

    List<ChildrenVO> getHsqList();
}
