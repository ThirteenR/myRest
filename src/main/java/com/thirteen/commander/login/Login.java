package com.thirteen.commander.login;

import com.thirteen.component.login.service.LoginService;
import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.core.response.ResponseJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: rsq0113
 * Date: 2018-09-03 16:07
 * Description:
 **/
@RestController
@RequestMapping("/login")
public class Login {

    @Resource
    LoginService loginServic;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJson login(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo){
        ResponseJson login = loginServic.login(request, response, userInfo);
        return login;
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseJson logout(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo){
        return loginServic.logout(request,response,userInfo);
    }
}
