package example.Controller;


import com.example.Entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
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
}
