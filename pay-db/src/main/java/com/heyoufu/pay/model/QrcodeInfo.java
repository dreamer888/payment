package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
    * 二维码信息表
    */
@ApiModel(value="com-heyoufu-pay-model-QrcodeInfo")
@Data
public class QrcodeInfo implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 二维码编号
    */
    @ApiModelProperty(value="二维码编号")
    private String qrcodeNo;

    /**
    * 二维码链接
    */
    @ApiModelProperty(value="二维码链接")
    private String qrcodeUrl;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
    * 商户编号
    */
    @ApiModelProperty(value="商户编号")
    private String merchantNo;

    /**
    * 商户名
    */
    @ApiModelProperty(value="商户名")
    private String merchantName;

    /**
    * varchar
    */
    @ApiModelProperty(value="varchar")
    private Integer status;

    /**
    * 通道id
    */
    @ApiModelProperty(value="通道id")
    private Long channelId;

    /**
    * 上游商户号否
    */
    @ApiModelProperty(value="上游商户号")
    private String upstreamMerchantNo;

    /**
    * 用户头像
    */
    @ApiModelProperty(value="用户头像")
    private String userHeader;

    /**
    * 代理商编号
    */
    @ApiModelProperty(value="代理商编号")
    private String agentNo;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private Long createUser;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
    * 修改人
    */
    @ApiModelProperty(value="修改人")
    private Long updateUser;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}