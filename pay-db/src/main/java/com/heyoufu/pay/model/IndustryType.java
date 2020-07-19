package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 行业类别表
    */
@ApiModel(value="com-heyoufu-pay-model-IndustryType")
@Data
public class IndustryType implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 经营类目一级
    */
    @ApiModelProperty(value="经营类目一级")
    private String businessTypeFirst;

    /**
    * 经营类目二级
    */
    @ApiModelProperty(value="经营类目二级")
    private String businessTypeSecond;

    /**
    * 经营类目三级
    */
    @ApiModelProperty(value="经营类目三级")
    private String businessTypeThirdly;

    /**
    * MCC码
    */
    @ApiModelProperty(value="MCC码")
    private String mccCode;

    private static final long serialVersionUID = 1L;
}