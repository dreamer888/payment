package com.heyoufu.merchant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyoufu.merchant.service.PaymentOrderService;
import com.heyoufu.merchant.vo.dtoVO.AppPaymentOrderDtoVO;
import com.heyoufu.merchant.vo.dtoVO.ChildrenVO;
import com.heyoufu.merchant.vo.dtoVO.FindTimeByAppListDto;
import com.heyoufu.merchant.vo.searchVO.OrderBillSearchVO;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.OrderTimeSerchVo;
import com.heyoufu.pay.common.vo.payMerchant.serchVO.payOrderSerchVO;
import com.heyoufu.pay.mapper.PaymentOrderMapper;
import com.heyoufu.pay.model.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/9 9:35
 * 4
 */
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

        @Autowired
        private PaymentOrderMapper paymentOrderMapper;

        @Override
        public PageInfo<PaymentOrder> list(payOrderSerchVO vo) {
            PageHelper.startPage(vo.getPage(), vo.getSize());
        List<PaymentOrder> paymentOrders = paymentOrderMapper.list(vo.getPoNo());
        PageInfo<PaymentOrder> pageInfo = new PageInfo<>(paymentOrders);
        return pageInfo;
    }

    @Override
    public AppPaymentOrderDtoVO getPoNoTimeOrder(OrderTimeSerchVo vo) {
        if(vo == null ){
            throw new RuntimeException("参数不得为空");
        } else if("".equals(vo.getPoNo()) || vo.getPoNo().isEmpty()){
            throw new RuntimeException("收款商户号不得为空");
        }
        AppPaymentOrderDtoVO appPaymentOrderVo = new AppPaymentOrderDtoVO();
        if(vo.getStarTime().isEmpty() || vo.getEndTime().isEmpty()){
            DateFormat day = new SimpleDateFormat("yyyy-MM-dd");
            String today = day.format(new Date());
            List<PaymentOrder> listOrder = paymentOrderMapper.getDayOrder(vo.getPoNo(), today);
            appPaymentOrderVo.setPaymentOrder(listOrder);
            appPaymentOrderVo.setTotalTransaction(listOrder.size());
            appPaymentOrderVo.setReceived(paymentOrderMapper.getAmout(vo.getPoNo(), today));
            return appPaymentOrderVo;
        }
        List<PaymentOrder> listOrder = paymentOrderMapper.getPoNoTimeOrder(vo.getPoNo(),vo.getStarTime(),vo.getEndTime());
        appPaymentOrderVo.setPaymentOrder(listOrder);
        appPaymentOrderVo.setTotalTransaction(listOrder.size());
        appPaymentOrderVo.setReceived(paymentOrderMapper.getDayAmout(vo.getPoNo(),vo.getStarTime(),vo.getEndTime()));
        return appPaymentOrderVo;
    }


    @Override
    public List<FindTimeByAppListDto> findTimeByAppList(OrderBillSearchVO orderBillSearchVo) {
        if(orderBillSearchVo.getPono()== null){
            throw new RuntimeException("收款商户号不得为空！");
        }



        return null;
    }

    @Override
    public List<ChildrenVO> getHsqStatusList() {
        List<ChildrenVO> child = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("SUCCESS","交易成功");
        map.put("REFUNDED","已退款");
        map.put("REVOKED","已撤销");
        map.put("IN_TRANSACTION","预订单");
        map.put("PENDING_PAYMENT","待付款");
        map.put("TRANSACTION_FAILED","交易失败");
        for(Map.Entry<String, String> entry : map.entrySet()){
            ChildrenVO ld = new ChildrenVO();
            ld.setValue(entry.getKey());
            ld.setLabel(entry.getValue());
            child.add(ld);
        }
        return child;
    }

    @Override
    public List<ChildrenVO> getHsqList() {
        List<ChildrenVO> child = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("ALI_BARCODEPAY","支付宝-条码支付");
        map.put("ALI_NATIVE","支付宝-扫码支付");
        map.put("WECHAT_MICROPAY","微信-条码支付");
        map.put("WECHAT_JSAPI","微信-公众号支付");
        for(Map.Entry<String, String> rest : map.entrySet()){
            ChildrenVO vo = new ChildrenVO();
            vo.setValue(rest.getKey());
            vo.setLabel(rest.getValue());
            child.add(vo);
        }
        return child;
    }


}
