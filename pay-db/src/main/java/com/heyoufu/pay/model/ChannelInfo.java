package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 通道信息表
    */
@ApiModel(value="com-heyoufu-pay-model-ChannelInfo")
@Data
public class ChannelInfo implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 通道名称
    */
    @ApiModelProperty(value="通道名称")
    private String channelName;

    /**
    * 通道说明
    */
    @ApiModelProperty(value="通道说明")
    private String channelDesc;

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