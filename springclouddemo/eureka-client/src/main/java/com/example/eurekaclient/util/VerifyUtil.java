package com.example.eurekaclient.util;

import com.example.eurekaclient.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by baixuyan on 2018/5/25
 *
 * @author baixuyan
 **/

public class VerifyUtil
{
    public boolean verifyregister(User user) {
        if ((!MobileFormat(user))|(!emailFormat(user))|(!check(user))){
            System.out.println(" Invalid password"+ "\n" +"输入错误：密码不符合规则，请重新输入!");
            return false;
        }else{
            System.out.println(" valid password");
            return true;
        }
    }
    /**
     * 检查字符串是否为合法手机号码
     * @param {String} 字符串
     * @return {bool} 是否为合法手机号码
     */
    public static boolean MobileFormat(User user) {
        String mobileNo = user.getMobile();
        boolean flag = false;
        // 手机号码：^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
        String pattern = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(pattern);
        Matcher match = p.matcher(mobileNo);
        if (mobileNo != null) {
            flag = match.matches();
        }
        return flag;
    }

    /**
     * 检查字符串是否为合法email地址
     * @param {String} 字符串
     * @return {bool} 是否为合法email地址
     */
    public static boolean emailFormat(User user)
    {
        String email =user.getEmail();
        boolean flag = true;
        // Email地址：^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
        String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            flag = false;
        }
        return flag;
    }

    /**
     * 检查密码规则校验 (不能 少于 6位， 至少 包含字母，特殊符号)
     * @param {String} 字符串
     * @return {bool} 是否为符合长度的字符串
     */
    public static boolean check(User user) {

        String pwd = user.getPwd();
        String pattern1 = "(^[a-zA-Z]+$)";
        //String patternStr1 = "([0-9]|[a-zA-Z]){6,20}";
        // \W,与任何非单词字符匹配
        //String patternStr2 = "([^A-Za-z0-9_]);
        String pattern2 = "(^[^%&',;=?$\\x22]+$)";
        boolean result1 = Pattern.matches(pattern1, pwd);
        boolean result2 = Pattern.matches(pattern2, pwd);
        boolean result3 = (pwd.length() > 6);
        if (result1 && result2 && result3) {
            return true;
        } else {
            return false;
        }
    }
}
