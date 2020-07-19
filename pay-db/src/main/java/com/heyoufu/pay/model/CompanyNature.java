package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 公司性质表
    */
@ApiModel(value="com-heyoufu-pay-model-CompanyNature")
@Data
public class CompanyNature implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 工作单位性质编号
    */
    @ApiModelProperty(value="工作单位性质编号")
    private String companyNatureId;

    /**
    *  工作单位性质名称
    */
    @ApiModelProperty(value=" 工作单位性质名称")
    private String companyNatureName;

    private static final long serialVersionUID = 1L;
}