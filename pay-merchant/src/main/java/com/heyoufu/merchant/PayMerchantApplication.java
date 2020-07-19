package com.heyoufu.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@EnableFeignClients   //需要调用其他服务的时候 可以开启这个注解 使用负载均衡功能， 并在具体的调用服务商使用 @EnableFeignClient 注解，可以参考 pay-demo
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.heyoufu.pay.mapper")
public class PayMerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayMerchantApplication.class, args);
        System.out.println("商户模块已启动....");

    }

}
