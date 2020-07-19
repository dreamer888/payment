package com.heyoufu.channel.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 *   lgl on 2020-05-26
 *   扫描路径根据实际情况配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.heyoufu.pay.mapper","com.heyoufu.demo.mapper"})
public class MyBatisConfig {
}
