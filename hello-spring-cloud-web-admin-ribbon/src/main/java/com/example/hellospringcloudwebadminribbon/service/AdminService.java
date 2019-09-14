package com.example.hellospringcloudwebadminribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;
    public String sayHi(String message){
        return restTemplate.getForObject(String.format("http://hello-spring-cloud-service-admin/hi?message=%s",message),String.class);
    }
}
