package example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MyApplication {
    /**
     * 使用spring提供的RestTemplate发送http请求调用微服务
     * 这里创建RestTemplate对象交给容器管理
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
