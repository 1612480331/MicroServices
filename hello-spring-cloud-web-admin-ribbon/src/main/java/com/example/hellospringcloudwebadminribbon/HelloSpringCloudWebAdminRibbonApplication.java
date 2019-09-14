package com.example.hellospringcloudwebadminribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloSpringCloudWebAdminRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudWebAdminRibbonApplication.class, args);
    }

}
