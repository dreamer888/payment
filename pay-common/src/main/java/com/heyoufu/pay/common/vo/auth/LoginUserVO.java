package com.heyoufu.pay.common.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * xzm 2020-5-18
 */
@ApiModel(value = "基础登录用户")
@Data
public class LoginUserVO {

    @ApiModelProperty(value = "客户端id")
    private String client_id;

    @ApiModelProperty(value = "客户端秘钥")
    private String client_secret;

//    @ApiModelProperty(value = "授权类型")
//    private String grant_type;
//
//    @ApiModelProperty(value = "授权作用域")
//    private String scope;

}
