package com.example.eurekaclient.service.Impl;

/**
 * created by baixuyan on 2018/5/25
 *
 * @author baixuyan
 **/

import com.alibaba.fastjson.JSON;
import com.example.eurekaclient.mapper.UserMapper;
import com.example.eurekaclient.model.User;
import com.example.eurekaclient.service.UserService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * created by baixuyan on 2018/5/22
 *
 * @author baixuyan
 **/

@Service
@ComponentScan("com.example.user.mapper.UserMapper")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getListUser(){

        return userMapper.findInfo();
    }
    @Override
    public void insert(User user) {
        userMapper.addInfo(user);
    }

    @Override
    public User findById(int id){
        return userMapper.findById(id);
    }
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${file.prefix}")
    private String imgPrefix;

    /**
     * 通过缓存获取,不存在将从通过数据库获取用户对象,将用户对象写入缓存，设置缓存时间5分钟,返回对象
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        String key = "user:"+id;
        String json =  redisTemplate.opsForValue().get(key);
        User user = null;
        if (Strings.isNullOrEmpty(json)) {
            user =  userMapper.findById(id);
            user.setAvatar(imgPrefix + user.getAvatar());
            String string  = JSON.toJSONString(user);
            redisTemplate.opsForValue().set(key, string);
            redisTemplate.expire(key, 5, TimeUnit.MINUTES);
        }else {
            user = JSON.parseObject(json,User.class);
        }
        return user;
    }


}


