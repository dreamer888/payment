package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 登录日志表
    */
@ApiModel(value="com-heyoufu-pay-model-LogLogin")
@Data
public class LogLogin implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 登录用户名
    */
    @ApiModelProperty(value="登录用户名")
    private String loginUser;

    /**
    * 登录IP
    */
    @ApiModelProperty(value="登录IP")
    private String loginIp;

    /**
    * 登录位置
    */
    @ApiModelProperty(value="登录位置")
    private String loginLocation;

    /**
    * 登录信息
    */
    @ApiModelProperty(value="登录信息")
    private String loginMsg;

    /**
    * 登录时间
    */
    @ApiModelProperty(value="登录时间")
    private Date loginTime;

    private static final long serialVersionUID = 1L;
}