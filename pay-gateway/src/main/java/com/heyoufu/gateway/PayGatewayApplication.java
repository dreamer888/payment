package com.heyoufu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PayGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayGatewayApplication.class, args);

        System.out.println("pay-gateway is  running....");
    }

}
