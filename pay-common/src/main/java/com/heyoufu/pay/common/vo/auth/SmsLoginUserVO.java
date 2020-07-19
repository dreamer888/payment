package com.heyoufu.pay.common.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * xzm 2020-5-18
 */
@ApiModel(value = "手机短信验证码登录")
@Data
public class SmsLoginUserVO extends LoginUserVO {

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "短信验证码")
    private String smsCode;

}
