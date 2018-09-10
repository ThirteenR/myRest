package com.thirteen.component.user.service;

import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.core.norm.BaseService;
import com.thirteen.core.norm.User;

import java.util.Map;


/**
 * Author: rsq0113
 * Date: 2018-08-31 15:43
 * Description:
 **/
public interface UserService<T> extends BaseService<T> {
    Map<String, User> getLanded();
    UserInfo getCurrent(String token);
}
