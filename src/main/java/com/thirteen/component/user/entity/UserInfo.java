package com.thirteen.component.user.entity;

import com.thirteen.core.norm.User;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:23
 * Description:
 **/
public class UserInfo implements User {
    private int userId;
    private String userName;
    private String userRand;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRand() {
        return userRand;
    }

    public void setUserRand(String userRand) {
        this.userRand = userRand;
    }

    public int getUserId() {
        return userId;
    }
}
