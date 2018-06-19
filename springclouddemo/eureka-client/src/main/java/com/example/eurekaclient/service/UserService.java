package com.example.eurekaclient.service;

import com.example.eurekaclient.model.User;

import java.util.List;

/**
 * created by baixuyan on 2018/5/25
 *
 * @author baixuyan
 **/

public interface UserService {
    User findById(int id);

    void insert(User user);

    List<User> getListUser();

    /**
     * 1.首先通过缓存获取
     * 2.不存在将从通过数据库获取用户对象
     * 3.将用户对象写入缓存，设置缓存时间5分钟
     * 4.返回对象
     * @param id
     * @return
     */
    User getUserById(Integer id);

}
