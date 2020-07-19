package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色表
 */
@ApiModel(value = "com-heyoufu-pay-model-RoleInfo")
@Data
public class RoleInfo implements Serializable {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long id;

    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")
    private String name;

    /**
     * 角色标识
     */
    @ApiModelProperty(value = "角色标识")
    private String tag;

    /**
     * 角色状态: 正常或者禁用
     */
    @ApiModelProperty(value = "角色状态: 正常或者禁用")
    private Short status;

    /**
     * 创建人,系统创建则为-1
     */
    @ApiModelProperty(value = "创建人,系统创建则为-1")
    private Long createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改人,系统修改则为-1
     */
    @ApiModelProperty(value = "修改人,系统修改则为-1")
    private Long updateUser;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}