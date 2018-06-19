package com.example.eurekaclient.mapper;

import com.example.eurekaclient.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by baixuyan on 2018/5/25
 *
 * @author baixuyan
 **/


@Mapper
public interface UserMapper {


    User findById(int id);
    List<User> findInfo();
    int addInfo(User user);
    int add(@Param("id") int id, @Param("pwd") String pwd);
    int delInfo(int id);
    User selectResult(@Param("id") int id, @Param("pwd") String pwd);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

}

