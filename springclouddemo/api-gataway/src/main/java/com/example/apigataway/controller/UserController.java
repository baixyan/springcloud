package com.example.apigataway.controller;

/**
 * created by baixuyan on 2018/6/19
 *
 * @author baixuyan
 **/

import com.example.apigataway.feign.UserFeign;
import com.example.apigataway.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class UserController {
    //@Autowired

    private RestTemplate template;

    private UserFeign userFeign;

    //@RequestMapping("/user/list")
    //@ResponseBody
//	public String getUsers(){
//		ResponseEntity<String> response = template.getForEntity("http://127.0.0.1:8083/user/list", String.class);
//		return response.getBody();
//	}

    // feign

    @RequestMapping("/user/list")
    @ResponseBody
    public List<User> getUsers(){
        return userFeign.getUsers();
    }

    @GetMapping("/user/add")
    public User addUsers(User user) {
        return userFeign.addUsers(user);
    }
}