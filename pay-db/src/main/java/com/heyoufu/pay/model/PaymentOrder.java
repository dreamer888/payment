package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
    * 支付订单表
    */
@ApiModel(value="com-heyoufu-pay-model-PaymentOrder")
@Data
public class PaymentOrder implements Serializable {
    @ApiModelProperty(value="")
    private UUID id;

    /**
    * 订单号
    */
    @ApiModelProperty(value="订单号")
    private String orderNo;

    /**
    * 订单类型
    */
    @ApiModelProperty(value="订单类型")
    private String orderType;

    /**
    * 订单金额
    */
    @ApiModelProperty(value="订单金额")
    private BigDecimal orderMoney;

    /**
    * 订单优惠
    */
    @ApiModelProperty(value="订单优惠")
    private BigDecimal orderPreferential;

    /**
    * 支付金额
    */
    @ApiModelProperty(value="支付金额")
    private BigDecimal paymentMoney;

    /**
    * 订单备注
    */
    @ApiModelProperty(value="订单备注")
    private String orderRemarks;

    /**
    * 上游商户号
    */
    @ApiModelProperty(value="上游商户号")
    private String upstreamMerchantNo;

    /**
    * 系统商户号
    */
    @ApiModelProperty(value="系统商户号")
    private String systemMerchantNo;

    /**
    * 通道id
    */
    @ApiModelProperty(value="通道id")
    private Long channelId;

    /**
    * 推送id
    */
    @ApiModelProperty(value="推送id")
    private String messageId;

    /**
    * 订单状态
    */
    @ApiModelProperty(value="订单状态")
    private Long orderStatus;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private Long createUser;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}