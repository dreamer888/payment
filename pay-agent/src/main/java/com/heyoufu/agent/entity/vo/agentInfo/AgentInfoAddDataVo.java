package com.heyoufu.agent.entity.vo.agentInfo;

import com.heyoufu.agent.entity.dto.ChannelRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xnk
 * @data 2020/6/8 9:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新增代理商详细详细VO")
public class AgentInfoAddDataVo {

    @ApiModelProperty("代理商名称")
    private String agentName;
    @ApiModelProperty("上级代理商编号")
    private String supAgentNo;
    @ApiModelProperty("系统用户名")
    private String username;
    @ApiModelProperty("系统登录密码")
    private String password;
    @ApiModelProperty("系统手机号码")
    private Long mobile;
    @ApiModelProperty("电子邮箱")
    private String mail;
    @ApiModelProperty("代理商费率")
    private List<ChannelRate> agentRates;
    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("公司所在省编码")
    private String companyProvinceCode;
    @ApiModelProperty("公司所在省名称")
    private String companyProvinceText;
    @ApiModelProperty("公司所在市编码")
    private String companyCityCode;
    @ApiModelProperty("公司所在市名称")
    private String companyCityText;
    @ApiModelProperty("公司所在区编码")
    private String companyDistrictCode;
    @ApiModelProperty("公司所在区名称")
    private String companyDistrictText;
    @ApiModelProperty("公司详细地址")
    private String companyAddress;
    @ApiModelProperty("法人姓名 / 负责人姓名")
    private String name;
    @ApiModelProperty("法人手机号码 / 负责人手机号码")
    private String phone;
    @ApiModelProperty("法人身份证号码 / 负责人身份证号码")
    private String idCardNo;
    @ApiModelProperty("结算帐户帐号")
    private String bankAccountNo;
    @ApiModelProperty("开户名")
    private String bankAccountName;
    @ApiModelProperty("开户行号")
    private String bankNo;
    @ApiModelProperty("联行号")
    private String cnapsNo;
    @ApiModelProperty("开户支行名称")
    private String subBranchBankName;
    @ApiModelProperty("开户支行所在省编码")
    private String depositBankProvinceCode;
    @ApiModelProperty("开户支行所在市编码")
    private String depositBankCityCode;
    @ApiModelProperty("联系地址所在省编码")
    private String contactProvinceCode;
    @ApiModelProperty("联系地址所在省名称")
    private String contactProvinceText;
    @ApiModelProperty("联系地址所在市编码")
    private String contactCityCode;
    @ApiModelProperty("联系地址所在市名称")
    private String contactCityText;
    @ApiModelProperty("联系地址所在区编码")
    private String contactDistrictCode;
    @ApiModelProperty("联系地址所在区名称")
    private String contactDistrictText;
    @ApiModelProperty("详细联系地址")
    private String contactAddress;
    @ApiModelProperty("代理商类型")
    private String agentType;
    @ApiModelProperty("用户是否已存在")
    private Boolean accountStatus;
}
