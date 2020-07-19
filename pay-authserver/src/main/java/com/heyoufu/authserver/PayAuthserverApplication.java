package com.heyoufu.authserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.heyoufu.pay.mapper")
public class PayAuthserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAuthserverApplication.class, args);
    }

}
