package com.example.hellospringcloudwebadminribbon.controller;

import com.example.hellospringcloudwebadminribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("hi")
    public String sayHi(String msg){
        return adminService.sayHi(msg);
    }
}
