package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 上游审核商户表
    */
@ApiModel(value="com-heyoufu-pay-model-MerchantReviewUpstream")
@Data
public class MerchantReviewUpstream implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 系统审核id
    */
    @ApiModelProperty(value="系统审核id")
    private Long systemReviewId;

    /**
    * 上游通道id
    */
    @ApiModelProperty(value="上游通道id")
    private Long upstreamChannelId;

    /**
    * 上游审核状态
    */
    @ApiModelProperty(value="上游审核状态")
    private String upstreamReviewStatus;

    /**
    * 系统审核状态
    */
    @ApiModelProperty(value="系统审核状态")
    private String systemReviewStatus;

    /**
    * 审核结果
    */
    @ApiModelProperty(value="审核结果")
    private String reviewResult;

    /**
    * 通道商户号
    */
    @ApiModelProperty(value="通道商户号")
    private String channelMerchantNo;

    /**
    * 通道流水号
    */
    @ApiModelProperty(value="通道流水号")
    private String channelBatchNo;

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