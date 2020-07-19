package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 代理商信息表
    */
@ApiModel(value="com-heyoufu-pay-model-AgentInfo")
@Data
public class AgentInfo implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 代理商编号
    */
    @ApiModelProperty(value="代理商编号")
    private String agentNo;

    /**
    * 代理商名称
    */
    @ApiModelProperty(value="代理商名称")
    private String agentName;

    /**
    * 代理商类型
    */
    @ApiModelProperty(value="代理商类型")
    private String agentType;

    /**
    * 公司名称
    */
    @ApiModelProperty(value="公司名称")
    private String companyName;

    /**
    * 公司所在省
    */
    @ApiModelProperty(value="公司所在省")
    private String companyProvince;

    /**
    * 公司所在市
    */
    @ApiModelProperty(value="公司所在市")
    private String companyCity;

    /**
    * 公司所在区
    */
    @ApiModelProperty(value="公司所在区")
    private String companyArea;

    /**
    * 公司所在街道
    */
    @ApiModelProperty(value="公司所在街道")
    private String companyStreet;

    /**
    * 法人姓名
    */
    @ApiModelProperty(value="法人姓名")
    private String representativeName;

    /**
    * 法人身份证号码 
    */
    @ApiModelProperty(value="法人身份证号码 ")
    private String representativeIdCard;

    /**
    * 法人手机号码
    */
    @ApiModelProperty(value="法人手机号码")
    private String representativePhone;

    /**
    * 银行卡卡号
    */
    @ApiModelProperty(value="银行卡卡号")
    private String bankAccountNo;

    /**
    * 开户名
    */
    @ApiModelProperty(value="开户名")
    private String bankAccountName;

    /**
    * 开户银行
    */
    @ApiModelProperty(value="开户银行")
    private String bankName;

    /**
    * 联系地址省
    */
    @ApiModelProperty(value="联系地址省")
    private String contactsProvince;

    /**
    * 联系地址市 
    */
    @ApiModelProperty(value="联系地址市 ")
    private String contactsCity;

    /**
    * 联系地址区
    */
    @ApiModelProperty(value="联系地址区")
    private String contactsArea;

    /**
    * 联系地址街道
    */
    @ApiModelProperty(value="联系地址街道")
    private String channelStreet;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 修改人
    */
    @ApiModelProperty(value="修改人")
    private String updateUser;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}