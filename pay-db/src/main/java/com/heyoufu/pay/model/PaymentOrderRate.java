package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
    * 订单费率表
    */
@ApiModel(value="com-heyoufu-pay-model-PaymentOrderRate")
@Data
public class PaymentOrderRate implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 费率类型
    */
    @ApiModelProperty(value="费率类型")
    private String rateType;

    /**
    * 上游商户号
    */
    @ApiModelProperty(value="上游商户号")
    private String upstreamMerchantNo;

    /**
    * 费率
    */
    @ApiModelProperty(value="费率")
    private BigDecimal rate;

    private static final long serialVersionUID = 1L;
}