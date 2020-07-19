package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 用户角色关联表
    */
@ApiModel(value="com-heyoufu-pay-model-UserRole")
@Data
public class UserRole implements Serializable {
    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 角色id
    */
    @ApiModelProperty(value="角色id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}