package com.thirteen.component.login.service;

import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.component.user.service.UserService;
import com.thirteen.core.exception.ConstException;
import com.thirteen.core.norm.LoginHandler;
import com.thirteen.core.norm.User;
import com.thirteen.core.response.ResponseEnum;
import com.thirteen.core.response.ResponseJson;
import com.thirteen.core.token.UserTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Author: rsq0113
 * Date: 2018-09-03 16:06
 * Description:
 **/
@Service
public class LoginService implements LoginHandler {
    @Resource
    private UserTokenManager tokenManager;
    @Resource
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Override
    public ResponseJson login(HttpServletRequest request, HttpServletResponse response, User u) {
        String token = request.getHeader(UserTokenManager.DEFAULT_TOKEN_NAME);
        /*匹配登陆用户*/
        UserInfo userInfo = matchUser((UserInfo) u);
        if (userInfo != null) {
            if (tokenManager.validJWT(token) != null) {
                logger.debug("用户Token已存在：" + token);
                throw new ConstException(ResponseEnum.IS_DOUBLE);
            }
            String key = hasLanded((UserInfo) u);
            return ResponseJson.success(tokenManager.createJWT(userInfo));
        }
        throw new ConstException(ResponseEnum.LOGIN_ERROR);
    }

    @Override
    public ResponseJson logout(HttpServletRequest request, HttpServletResponse response, User u) {
        return null;
    }

    private String hasLanded(UserInfo u) {
        return null;
    }

    private UserInfo matchUser(UserInfo userInfo) {
        UserInfo userInfo1 = (UserInfo) userService.get(userInfo).get(0);
        /* MD5Encod.getMD5(userInfo.getPassWord()).equals(userInfo1.getPassWord())*/
        if (userInfo1 != null && userInfo.getPassWord().equals(userInfo1.getPassWord())) {
            return userInfo1;
        }
        return null;
    }

}
