package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 用户权限表
    */
@ApiModel(value="com-heyoufu-pay-model-PermInfo")
@Data
public class PermInfo implements Serializable {
    /**
    * 权限id
    */
    @ApiModelProperty(value="权限id")
    private Long id;

    /**
    * 父级id
    */
    @ApiModelProperty(value="父级id")
    private Long supId;

    /**
    * 层级
    */
    @ApiModelProperty(value="层级")
    private Integer level;

    /**
    * 节点类型: {SUP_NODE:顶级节点,SUB_NODE:次级节点,LEAF_NODE:叶子节点,BUTTON_NODE:按钮节点,}
    */
    @ApiModelProperty(value="节点类型: {SUP_NODE:顶级节点,SUB_NODE:次级节点,LEAF_NODE:叶子节点,BUTTON_NODE:按钮节点,}")
    private String type;

    /**
    * 权限名称
    */
    @ApiModelProperty(value="权限名称")
    private String title;

    /**
    * 路由名称
    */
    @ApiModelProperty(value="路由名称")
    private String name;

    /**
    * 路由地址
    */
    @ApiModelProperty(value="路由地址")
    private String path;

    /**
    * 前端视图路径
    */
    @ApiModelProperty(value="前端视图路径")
    private String component;

    /**
    * 图标类型
    */
    @ApiModelProperty(value="图标类型")
    private String iconType;

    /**
    * 图标名称
    */
    @ApiModelProperty(value="图标名称")
    private String icon;

    /**
    * 排序值,值越小越靠前
    */
    @ApiModelProperty(value="排序值,值越小越靠前")
    private BigDecimal sequence;

    /**
    * 是否在侧边菜单隐藏
    */
    @ApiModelProperty(value="是否在侧边菜单隐藏")
    private Boolean hidden;

    /**
    * 是否总在侧边栏显示
    */
    @ApiModelProperty(value="是否总在侧边栏显示")
    private Boolean show;

    /**
    * 是否禁用
    */
    @ApiModelProperty(value="是否禁用")
    private Boolean enabled;

    /**
    * 是否前端缓存
    */
    @ApiModelProperty(value="是否前端缓存")
    private Boolean cache;

    /**
    * 是否固定在标签栏
    */
    @ApiModelProperty(value="是否固定在标签栏")
    private Boolean affix;

    /**
    * 是否在面包屑导航上显示
    */
    @ApiModelProperty(value="是否在面包屑导航上显示")
    private Boolean breadcrumb;

    /**
    * 面包屑重定义地址
    */
    @ApiModelProperty(value="面包屑重定义地址")
    private String redirect;

    /**
    * 需要高亮显示的菜单
    */
    @ApiModelProperty(value="需要高亮显示的菜单")
    private String active;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}