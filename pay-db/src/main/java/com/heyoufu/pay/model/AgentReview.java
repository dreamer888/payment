package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
    * 代理商审核表
    */
@ApiModel(value="com-heyoufu-pay-model-AgentReview")
@Data
public class AgentReview implements Serializable {
    @ApiModelProperty(value="")
    private UUID id;

    /**
    * 代理商id
    */
    @ApiModelProperty(value="代理商id")
    private Long agentId;

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