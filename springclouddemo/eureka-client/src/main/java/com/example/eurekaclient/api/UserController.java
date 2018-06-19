package com.example.eurekaclient.api;

/**
 * created by baixuyan on 2018/5/25
 *
 * @author baixuyan
 **/

import com.alibaba.fastjson.JSONObject;
import com.example.eurekaclient.model.User;
import com.example.eurekaclient.service.UserService;
import com.example.eurekaclient.util.VerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping(value = "/find")
    public User getUser(@RequestBody User user){
        //@PathVariable是用来获得请求url中的动态参数的，
        // 所以该注解只能支持将参数放在请求url的GET提交方式，所以不管你如何进行设置，@PathVariable都是无法支持Post请求的。
        User u = userService.findById(user.getId());
        return u;
    }

    @PostMapping(value = "/insertUser")
    public boolean insertUser(@RequestBody User user){
        try{
            VerifyUtil verifyUtil = new VerifyUtil();
            if (verifyUtil.verifyregister(user)){
                userService.insert(user);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public JSONObject getListUser(){
        List<User> list= userService.getListUser();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("code","200");
        jsonobject.put("msg","成功");
        jsonobject.put("data",list);
        return jsonobject;
    }

    @RequestMapping(value = "/getlist")
    @ResponseBody
    public JSONObject getUserListById(Integer id){
        List<User> list= (List<User>) userService.getUserById(id);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("code","200");
        jsonobject.put("msg","成功");
        jsonobject.put("data",list);
        return jsonobject;
    }

}


