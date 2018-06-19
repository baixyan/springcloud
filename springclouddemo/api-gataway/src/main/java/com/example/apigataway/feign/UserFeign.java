package com.example.apigataway.feign;

/**
 * created by baixuyan on 2018/6/19
 *
 * @author baixuyan
 **/
import com.example.apigataway.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient("user")
public interface UserFeign {

    //@RequestMapping(value="/user/list",method=RequestMethod.GET)

    @GetMapping("/user/list")
    List<User> getUsers();

    @GetMapping("/user/add")
    User addUsers(User user);

}
