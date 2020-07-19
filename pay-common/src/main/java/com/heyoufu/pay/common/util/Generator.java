package com.heyoufu.pay.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 生成器
 */
public class Generator {

    private static final Snowflake snowflake = IdUtil.createSnowflake(0, 0);

    /**
     * 生成分布式主键id
     * @return
     */
    public static Long getId() {
        return snowflake.nextId();
    }

    /**
     * 获取商户号
     * @return
     */
    public static String getMerchantNo() {
        return new StringBuilder(String.valueOf(snowflake.nextId())).insert(11, "000").toString();
    }

    public static void main(String[] args) {
        System.out.println(getMerchantNo());
    }
}