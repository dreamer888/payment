package com.heyoufu.pay.common.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * xzm 2020-5-18
 */
@ApiModel(value = "表单登录")
@Data
public class FormLoginUserVO extends LoginUserVO {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}
