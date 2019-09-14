package com.example.hellospringcloudwebadminfeign.service.hystrix;

import com.example.hellospringcloudwebadminfeign.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String SaiHi(String msg) {
        return String.format("your msg is:%s,but request bad",msg);
    }
}
