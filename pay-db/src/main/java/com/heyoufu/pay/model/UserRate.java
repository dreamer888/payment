package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 用户费率表
    */
@ApiModel(value="com-heyoufu-pay-model-UserRate")
@Data
public class UserRate implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 代理商费率
    */
    @ApiModelProperty(value="代理商费率")
    private BigDecimal agentRate;

    /**
    * 商户费率
    */
    @ApiModelProperty(value="商户费率")
    private BigDecimal merchantRate;

    /**
    * 通道id
    */
    @ApiModelProperty(value="通道id")
    private Long channelId;

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

    /**
    * 修改人
    */
    @ApiModelProperty(value="修改人")
    private Long updateUser;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}