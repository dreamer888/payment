package com.heyoufu.pay.mapper;

import com.heyoufu.pay.model.PaymentOrder;

import java.util.List;
import java.util.UUID;

public interface PaymentOrderMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(PaymentOrder record);

    int insertSelective(PaymentOrder record);

    PaymentOrder selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(PaymentOrder record);

    int updateByPrimaryKey(PaymentOrder record);

    List<PaymentOrder> list(String poNo);

    List<PaymentOrder> getDayOrder(String poNo, String today);

    List<PaymentOrder> getPoNoTimeOrder(String poNo, String starTime, String endTime);

    double getAmout(String poNo, String today);

    double getDayAmout(String poNo, String starTime, String endTime);
}