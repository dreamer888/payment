package com.heyoufu.merchant.vo.dtoVO;

import com.heyoufu.pay.model.PaymentOrder;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * 2 * @Author: xuan
 * 3 * @Date: 2020/6/11 9:35
 * 4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("app查询订单返回VO")
@Builder
public class AppPaymentOrderDtoVO {

    private Integer totalTransaction;

    private double received;

    private List<PaymentOrder> paymentOrder;

}
