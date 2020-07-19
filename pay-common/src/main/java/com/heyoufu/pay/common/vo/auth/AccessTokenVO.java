package com.heyoufu.pay.common.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * xzm 2020-5-18
 */
@ApiModel(value = "令牌实体")
@Data
public class AccessTokenVO {

    @ApiModelProperty(value = "令牌")
    private String access_token;

    @ApiModelProperty(value = "令牌类型")
    private String token_type;

    @ApiModelProperty(value = "刷新令牌")
    private String refresh_token;

    @ApiModelProperty(value = "令牌有效时间")
    private Integer expires_in;

    @ApiModelProperty(value = "令牌作用域")
    private String scope;

    @ApiModelProperty(value = "jti")
    private String jti;

}
