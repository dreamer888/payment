package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 系统服务表
    */
@ApiModel(value="com-heyoufu-pay-model-SystemService")
@Data
public class SystemService implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 服务名
    */
    @ApiModelProperty(value="服务名")
    private String serviceName;

    /**
    * 服务详情
    */
    @ApiModelProperty(value="服务详情")
    private String serviceInfo;

    /**
    * 服务状态
    */
    @ApiModelProperty(value="服务状态")
    private String status;

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