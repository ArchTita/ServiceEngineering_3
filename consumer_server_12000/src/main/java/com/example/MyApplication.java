package com.example;


import com.example.Configuration.ConsumerLoadBalancerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name = "provider-server",configuration = ConsumerLoadBalancerConfiguration.class)
public class MyApplication {
    /**
     * 使用spring提供的RestTemplate发送http请求调用微服务
     * 这里创建RestTemplate对象交给容器管理
     */

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

}
