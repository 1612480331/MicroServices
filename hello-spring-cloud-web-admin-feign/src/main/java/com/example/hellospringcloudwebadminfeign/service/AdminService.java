package com.example.hellospringcloudwebadminfeign.service;

import com.example.hellospringcloudwebadminfeign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "hello-spring-cloud-service-admin",fallback = AdminServiceHystrix.class)
public interface AdminService {
    /**
     * 参数、函数名随便命名
     * @RequestMapping("hi")  绑定服务提供者的Rest Api
     * @param msg
     * @return
     */
    @RequestMapping("hi")
    String SaiHi(@RequestParam(value = "message") String msg);  //@RequestParam绑定服务提供方的参数
}
