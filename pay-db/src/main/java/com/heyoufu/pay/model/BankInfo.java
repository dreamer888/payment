package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 银行信息表
    */
@ApiModel(value="com-heyoufu-pay-model-BankInfo")
@Data
public class BankInfo implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 银行id
    */
    @ApiModelProperty(value="银行id")
    private String bankId;

    /**
    * 银行名称
    */
    @ApiModelProperty(value="银行名称")
    private String bankName;

    /**
    * 支行名称
    */
    @ApiModelProperty(value="支行名称")
    private String bankBranchName;

    /**
    * 联行号
    */
    @ApiModelProperty(value="联行号")
    private String bankUniteCode;

    /**
    * 所在省份id
    */
    @ApiModelProperty(value="所在省份id")
    private Integer provinceId;

    /**
    * 所在省份
    */
    @ApiModelProperty(value="所在省份")
    private String province;

    /**
    * 所在市区id
    */
    @ApiModelProperty(value="所在市区id")
    private Integer cityId;

    /**
    * 所在市区
    */
    @ApiModelProperty(value="所在市区")
    private String city;

    private static final long serialVersionUID = 1L;
}