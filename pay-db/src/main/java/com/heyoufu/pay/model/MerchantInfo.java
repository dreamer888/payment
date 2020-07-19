package com.heyoufu.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商户信息表
 */
@ApiModel(value = "com-heyoufu-pay-model-MerchantInfo")
@Data
public class MerchantInfo implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 商户号
     */
    @ApiModelProperty(value = "商户号")
    private String merchantNo;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

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

    /**
     * 商户类型
     */
    @ApiModelProperty(value = "商户类型")
    private String merchantType;

    /**
     * 商户全称
     */
    @ApiModelProperty(value = "商户全称")
    private String merchantName;

    /**
     * 商户简称
     */
    @ApiModelProperty(value = "商户简称")
    private String merchantShortName;

    /**
     * 法人姓名
     */
    @ApiModelProperty(value = "法人姓名")
    private String corporateName;

    /**
     * 法人证件号
     */
    @ApiModelProperty(value = "法人证件号")
    private String corporateIdCardNo;

    /**
     * 法人证件有效期开始日期
     */
    @ApiModelProperty(value = "法人证件有效期开始日期")
    private Date corporateIdCardBeginDate;

    /**
     * 法人证件有效期截止日期
     */
    @ApiModelProperty(value = "法人证件有效期截止日期")
    private Date corporateIdCardEndDate;

    /**
     * 法人手机号
     */
    @ApiModelProperty(value = "法人手机号")
    private String corporatePhone;

    /**
     * 法人证件类型
     */
    @ApiModelProperty(value = "法人证件类型")
    private String corporateIdCardType;

    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名")
    private String name;

    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String phone;

    /**
     * 负责人证件号
     */
    @ApiModelProperty(value = "负责人证件号")
    private String idCardNo;

    /**
     * 负责人证件有效期开始日期
     */
    @ApiModelProperty(value = "负责人证件有效期开始日期")
    private Date idCardBeginDate;

    /**
     * 负责人证件有效期截止日期
     */
    @ApiModelProperty(value = "负责人证件有效期截止日期")
    private Date idCardEndDate;

    /**
     * 负责人证件类型
     */
    @ApiModelProperty(value = "负责人证件类型")
    private String idCardType;

    /**
     * 居住地省份码
     */
    @ApiModelProperty(value = "居住地省份码")
    private String residenceProvinceCode;

    /**
     * 居住地城市码
     */
    @ApiModelProperty(value = "居住地城市码")
    private String residenceCityCode;

    /**
     * 居住地地区码
     */
    @ApiModelProperty(value = "居住地地区码")
    private String residenceDistrictCode;

    /**
     * 居住地详细地址
     */
    @ApiModelProperty(value = "居住地详细地址")
    private String residenceAddress;

    /**
     * 民族码
     */
    @ApiModelProperty(value = "民族码")
    private String nation;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String gender;

    /**
     * 国籍码
     */
    @ApiModelProperty(value = "国籍码")
    private String nationality;

    /**
     * 营业执照有效期开始时间
     */
    @ApiModelProperty(value = "营业执照有效期开始时间")
    private Date businessLicenseBeginDate;

    /**
     * 营业执照有效期截止时间
     */
    @ApiModelProperty(value = "营业执照有效期截止时间")
    private Date businessLicenseEndDate;

    /**
     * 营业执照编号
     */
    @ApiModelProperty(value = "营业执照编号")
    private String businessLicenseNo;

    /**
     * 营业场所省份码
     */
    @ApiModelProperty(value = "营业场所省份码")
    private String provinceCode;

    /**
     * 营业场所城市码
     */
    @ApiModelProperty(value = "营业场所城市码")
    private String cityCode;

    /**
     * 营业场所地区码
     */
    @ApiModelProperty(value = "营业场所地区码")
    private String districtCode;

    /**
     * 营业场所详细地址
     */
    @ApiModelProperty(value = "营业场所详细地址")
    private String address;

    /**
     * 证件所在地省份码
     */
    @ApiModelProperty(value = "证件所在地省份码")
    private String idCardProvinceCode;

    /**
     * 证件所在地城市码
     */
    @ApiModelProperty(value = "证件所在地城市码")
    private String idCardCityCode;

    /**
     * 证件所在区地区码
     */
    @ApiModelProperty(value = "证件所在区地区码")
    private String idCardDistrictCode;

    /**
     * 证件所在地详细地址
     */
    @ApiModelProperty(value = "证件所在地详细地址")
    private String idCardAddress;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String latitude;

    /**
     * 二维码连接
     */
    @ApiModelProperty(value = "二维码连接")
    private String code;

    /**
     * 开户人
     */
    @ApiModelProperty(value = "开户人")
    private String bankCardName;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    private String bankCardNo;

    /**
     * 开户行号
     */
    @ApiModelProperty(value = "开户行号")
    private String bankNo;

    /**
     * 联行号
     */
    @ApiModelProperty(value = "联行号")
    private String cnapsNo;

    /**
     * 开户支行名称
     */
    @ApiModelProperty(value = "开户支行名称")
    private String subBranchBankName;

    /**
     * 银行预留手机号
     */
    @ApiModelProperty(value = "银行预留手机号")
    private String bankPhone;

    /**
     * 支行所在地省份码
     */
    @ApiModelProperty(value = "支行所在地省份码")
    private String depositBankProvinceCode;

    /**
     * 支行所在地城市码
     */
    @ApiModelProperty(value = "支行所在地城市码")
    private String depositBankCityCode;

    /**
     * 客服电话
     */
    @ApiModelProperty(value = "客服电话")
    private String servicePhone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 行业类别码
     */
    @ApiModelProperty(value = "行业类别码")
    private String industryType;

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    /**
     * 联系人手机号
     */
    @ApiModelProperty(value = "联系人手机号")
    private String contactPhone;

    /**
     * 联系人邮箱
     */
    @ApiModelProperty(value = "联系人邮箱")
    private String contactEmail;

    /**
     * 联系人证件类型
     */
    @ApiModelProperty(value = "联系人证件类型")
    private String contactIdCardType;

    /**
     * 联系人证件号
     */
    @ApiModelProperty(value = "联系人证件号")
    private String contactIdCardNo;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    /**
     * 公司详细地址
     */
    @ApiModelProperty(value = "公司详细地址")
    private String companyAddress;

    /**
     * 工作单位性质
     */
    @ApiModelProperty(value = "工作单位性质")
    private String companyNature;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String userAvatarImg;

    /**
     * 营业执照图片
     */
    @ApiModelProperty(value = "营业执照图片")
    private String businessLicenseImg;

    /**
     * 平台协议首页
     */
    @ApiModelProperty(value = "平台协议首页")
    private String protocolFirstImg;

    /**
     * 平台协议尾页
     */
    @ApiModelProperty(value = "平台协议尾页")
    private String protocolLastImg;

    /**
     * 证件正面照
     */
    @ApiModelProperty(value = "证件正面照")
    private String idCardFrontImg;

    /**
     * 证件反面照
     */
    @ApiModelProperty(value = "证件反面照")
    private String idCardBackImg;

    /**
     * 手持证件正面照
     */
    @ApiModelProperty(value = "手持证件正面照")
    private String idCardHandImg;

    /**
     * 门头照
     */
    @ApiModelProperty(value = "门头照")
    private String storeImg;

    /**
     * 开户许可证
     */
    @ApiModelProperty(value = "开户许可证")
    private String bankLicenseImg;

    /**
     * 工商网截图
     */
    @ApiModelProperty(value = "工商网截图")
    private String icNetScreenShotImg;

    /**
     * icp备案照片
     */
    @ApiModelProperty(value = "icp备案照片")
    private String icpImg;

    /**
     * 营业场所照片
     */
    @ApiModelProperty(value = "营业场所照片")
    private String placeImg;

    /**
     * 银行卡正面照
     */
    @ApiModelProperty(value = "银行卡正面照")
    private String bankCardFrontImg;

    /**
     * 银行卡反面照
     */
    @ApiModelProperty(value = "银行卡反面照")
    private String bankCardBackImg;

    /**
     * 用户标识
     */
    @ApiModelProperty(value = "用户标识")
    private Long userId;

    private static final long serialVersionUID = 1L;
}