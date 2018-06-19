package com.example.apigataway.model;

import java.sql.Date;

/**
 * created by baixuyan on 2018/6/19
 *
 * @author baixuyan
 **/
public class User
{
    private int id;

    private String email;

    private String mobile;

    private String avatar;

    private String pwd;

    private Date create_time;

    private Date update_time;

    public User(int id, String email, String mobile, String avatar, String pwd, Date create_time,
                Date update_time) {
        this.id = id;
        this.email = email;
        this.mobile = mobile;
        this.avatar = avatar;
        this.pwd = pwd;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", avatar='" + avatar + '\'' +
                ", pwd='" + pwd + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
