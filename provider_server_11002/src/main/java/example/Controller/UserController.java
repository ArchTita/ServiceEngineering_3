package example.Controller;

import com.example.Entity.CommonResult;
import com.example.Entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    User user = new User();
    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId){
        //模拟返回业务数据
        return new CommonResult(200,"success",new User(userId,"负载小黄","123"));
    }

    @PostMapping("/addUser")
    public CommonResult<User> addUser(@RequestBody User user){
        this.user = user;
        return new CommonResult(200,"you have just add a user!",this.user);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        this.user = user;
    }

    @DeleteMapping("/removeUser")
    public CommonResult<User> removeUser(){
        this.user = null;
        return new CommonResult(200,"you have just remove a user!",this.user);
    }








}
