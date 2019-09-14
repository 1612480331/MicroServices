package com.example.hellospringcloudserviceadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloSpringCloudServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudServiceAdminApplication.class, args);
    }

}
