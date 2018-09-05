package com.thirteen.core.norm;

/**
 * Author: rsq0113
 * Date: 2018-09-03 11:40
 * Description:
 **/
public interface TokenManager{
    String createToken(User u);
    boolean checkToken(String token);
    void deleteToken(String token);
}
