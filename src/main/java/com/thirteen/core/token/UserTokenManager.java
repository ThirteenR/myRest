package com.thirteen.core.token;

import com.github.pagehelper.StringUtil;
import com.thirteen.core.norm.TokenManager;
import com.thirteen.core.norm.User;
import com.thirteen.core.util.UUIDUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: rsq0113
 * Date: 2018-09-03 11:43
 * Description:
 **/
@Component
public class UserTokenManager implements TokenManager {
    public static final String DEFAULT_TOKEN_NAME = "x-token";
    /*JVM管理token*/
    private static Map<String,User> tokenMap = new ConcurrentHashMap<String, User>();
    @Override
    public String createToken(User u) {
        String token = UUIDUtil.createUUID();
        tokenMap.put(token, u);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }

    @Override
    public void deleteToken(String token) {
        tokenMap.remove(token);
    }
    public Map<String,User> getTokenMap(){
        return tokenMap;
    }
}
