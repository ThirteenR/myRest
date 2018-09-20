package com.thirteen.component.user.service;

import com.thirteen.component.user.dao.UserDao;
import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.core.norm.BaseServiceImpl;
import com.thirteen.core.norm.User;
import com.thirteen.core.token.UserTokenManager;
import com.thirteen.core.util.MD5Encod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:44
 * Description:
 **/
@Service
public class UserServiceImpl<T> extends BaseServiceImpl<T> implements UserService<T> {
     @Resource
     UserDao userDao;
     @Resource
     UserTokenManager tokenManager;
    @Override
    public int post(T t) {
        UserInfo userInfo = (UserInfo) t;
        userInfo.setPassWord(MD5Encod.getMD5(userInfo.getPassWord()));
        return userDao.post(userInfo);
    }

    @Override
    public Map<String, User> getLanded() {
        return  null;
    }

    @Override
    public UserInfo getCurrent(String token) {
        return null;
    }
}
