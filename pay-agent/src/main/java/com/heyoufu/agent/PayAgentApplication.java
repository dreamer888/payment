package com.heyoufu.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;


//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})  // 在pom 声明依赖数据源，特别是sql 数据源，和redis数据源，没有初始化会报错，通过该注解 禁止自动配置，或者声明禁止自动配置
@EnableFeignClients   //需要调用其他服务的时候 可以开启这个注解 使用负载均衡功能， 并在具体的调用服务商使用 @EnableFeignClient 注解，可以参考 pay-demo
@EnableDiscoveryClient
@SpringBootApplication
public class PayAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAgentApplication.class, args);
    }

}
