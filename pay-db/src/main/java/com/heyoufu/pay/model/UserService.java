package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 用户服务关联表
    */
@ApiModel(value="com-heyoufu-pay-model-UserService")
@Data
public class UserService implements Serializable {
    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 服务id
    */
    @ApiModelProperty(value="服务id")
    private Long serviceId;

    private static final long serialVersionUID = 1L;
}