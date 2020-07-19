package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.PaymentOrderRate;

public interface PaymentOrderRateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentOrderRate record);

    int insertSelective(PaymentOrderRate record);

    PaymentOrderRate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentOrderRate record);

    int updateByPrimaryKey(PaymentOrderRate record);
}