package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@ApiModel(value="com-heyoufu-pay-model-UserInfo")
@Data
public class UserInfo implements Serializable {
    /**
    * 唯一标志符
    */
    @ApiModelProperty(value="唯一标志符")
    private Long id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 登录密码
    */
    @ApiModelProperty(value="登录密码")
    private String password;

    /**
    * 手机号码
    */
    @ApiModelProperty(value="手机号码")
    private String phone;

    /**
    * 手机绑定状态
    */
    @ApiModelProperty(value="手机绑定状态")
    private Boolean phoneStatus;

    /**
    * 电子邮箱
    */
    @ApiModelProperty(value="电子邮箱")
    private String mail;

    /**
    * 邮箱绑定状态
    */
    @ApiModelProperty(value="邮箱绑定状态")
    private Boolean mailStatus;

    /**
    * 用户头像
    */
    @ApiModelProperty(value="用户头像")
    private String header;

    /**
    * 用户状态: 正常或者禁用
    */
    @ApiModelProperty(value="用户状态: 正常或者禁用")
    private Short status;

    /**
    * 创建人,系统创建则为-1
    */
    @ApiModelProperty(value="创建人,系统创建则为-1")
    private Long createUser;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 修改人,系统修改则为-1
    */
    @ApiModelProperty(value="修改人,系统修改则为-1")
    private Long updateUser;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}