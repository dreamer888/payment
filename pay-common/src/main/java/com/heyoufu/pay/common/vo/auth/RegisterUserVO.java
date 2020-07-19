package com.heyoufu.pay.common.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "注册用户")
@Data
public class RegisterUserVO {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "确认密码")
    private String rPassword;

    @ApiModelProperty(value = "电子邮箱")
    private String mail;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "验证码")
    private String checkCode;

    @ApiModelProperty(value = "邀请码")
    private String invitationCode;

    @ApiModelProperty(value = "二维码code")
    private String qrCode;

    @ApiModelProperty(value = "二维码代理商年龄")
    private String age;
}
