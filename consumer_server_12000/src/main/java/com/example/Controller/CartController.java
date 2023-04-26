package com.example.Controller;


import com.example.Entity.CommonResult;
import com.example.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/getUserById/{userId}")
    public CommonResult getUserById(@PathVariable("userId") Integer userId){
        //使用getForObject方法调用提供者微服务
        CommonResult result = restTemplate.getForObject(
                "http://localhost:11000/user/getUserById/"+userId, CommonResult.class);
        return result;
    }

    @GetMapping("/eureka/getUserById/{userId}")
    public CommonResult getUserByIdEureka(@PathVariable("userId") Integer userId){
        //使用getForObject方法调用提供者微服务
        CommonResult result = restTemplate.getForObject(
                "http://provider-server/user/getUserById/"+userId, CommonResult.class);
        return result;
    }


}
