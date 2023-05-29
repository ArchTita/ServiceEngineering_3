package com.example.Controller;


import com.example.Entity.CommonResult;
import com.example.Entity.User;


import com.example.Feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Result;


@RestController
@RequestMapping("/cart")
public class CartController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/getUserById/{userId}")
//    public CommonResult getUserById(@PathVariable("userId") Integer userId){
//        //使用getForObject方法调用提供者微服务
//        CommonResult result = restTemplate.getForObject(
//                "http://localhost:11000/user/getUserById/"+userId, CommonResult.class);
//        return result;
//    }
//
//    @GetMapping("/eureka/getUserById/{userId}")
//    public CommonResult getUserByIdEureka(@PathVariable("userId") Integer userId){
//        //使用getForObject方法调用提供者微服务
//        CommonResult result = restTemplate.getForObject(
//                "http://provider-server/user/getUserById/"+userId, CommonResult.class);
//        return result;
//    }
//
//    @PostMapping("/eureka/addUser")
//    public CommonResult addUser(@RequestBody User user){
//        ResponseEntity<CommonResult> result = restTemplate.postForEntity(
//                "http://provider-server/user/addUser", user, CommonResult.class);
//        return result.getBody();
//    }
//
//    @PutMapping("/eureka/updateUser")
//    public CommonResult updateUser(@RequestBody User user){
//        try{
//            restTemplate.put("http://provider-server/user/updateUser", user);
//            return new CommonResult(200,"you have just update a user!",user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new CommonResult(500,"failure!",null);
//        }
//    }
//
//    @DeleteMapping("/eureka/deleteUser")
//    public CommonResult deleteUser(){
//        try{
//
//            restTemplate.delete("http://provider-server/user/removeUser");
//            return new CommonResult(200,"delete!",null);
//        }catch(Exception e){
//            e.printStackTrace();
//            return new CommonResult(500,"delete failure!",null);
//        }
//
//    }
//

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/getUserById/{userId}")
    public CommonResult getUserById(@PathVariable("userId") Integer userId){
        //使用Fegin接口进行服务调用
        return userFeignClient.getUserById(userId);
    }


}
