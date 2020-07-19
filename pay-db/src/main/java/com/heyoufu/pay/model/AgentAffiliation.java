package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 代理商从属关系表
 */
@ApiModel(value = "com-heyoufu-pay-model-AgentAffiliation")
@Data
public class AgentAffiliation implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 代理商id
     */
    @ApiModelProperty(value = "代理商id")
    private Long agentId;

    /**
     * 子代理商id
     */
    @ApiModelProperty(value = "子代理商id")
    private Long subAgentId;

    /**
     * 子代理商编号
     */
    @ApiModelProperty(value = "子代理商编号")
    private String subAgentNo;

    /**
     * 子代理商名称
     */
    @ApiModelProperty(value = "子代理商名称")
    private String subAgentName;

    /**
     * 子商户id
     */
    @ApiModelProperty(value = "子商户id")
    private Long subMerchantId;

    /**
     * 子商户编号
     */
    @ApiModelProperty(value = "子商户编号")
    private String subMerchantNo;

    /**
     * 子商户名称
     */
    @ApiModelProperty(value = "子商户名称")
    private String subMerchantName;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人")
    private Long updateUser;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}