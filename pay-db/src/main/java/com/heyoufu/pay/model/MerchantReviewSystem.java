package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 系统审核商户表
    */
@ApiModel(value="com-heyoufu-pay-model-MerchantReviewSystem")
@Data
public class MerchantReviewSystem implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 商户号
    */
    @ApiModelProperty(value="商户号")
    private String merchantNo;

    /**
    * 审核状态
    */
    @ApiModelProperty(value="审核状态")
    private String reviewStatus;

    /**
    * 审核结果
    */
    @ApiModelProperty(value="审核结果")
    private String reviewResult;

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