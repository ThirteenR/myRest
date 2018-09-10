package com.thirteen.web.user;

import com.thirteen.component.user.entity.UserInfo;
import com.thirteen.component.user.service.UserService;
import com.thirteen.core.norm.TokenManager;
import com.thirteen.core.response.ResponseJson;
import com.thirteen.core.token.UserTokenManager;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Author: rsq0113
 * Date: 2018-08-31 15:51
 * Description:
 **/
@RestController
@RequestMapping("/users")
public class FirstCtrl {
    @Resource
    UserService userService;
    private Logger logger = LoggerFactory.getLogger(FirstCtrl.class);
    @RequestMapping(method = RequestMethod.GET)
    public ResponseJson get(UserInfo userInfo){
           return ResponseJson.success(userService.get(userInfo));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJson post(UserInfo userInfo){
        return ResponseJson.success(userService.post(userInfo));
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseJson put(UserInfo userInfo){
        return ResponseJson.success(userService.put(userInfo));
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseJson delete(UserInfo userInfo){
        return ResponseJson.success(userService.delete(userInfo));
    }
    @RequestMapping(value = "/landed",method = RequestMethod.GET)
    public ResponseJson landed(){
        return ResponseJson.success(userService.getLanded());
    }
    @RequestMapping(value = "/current",method = RequestMethod.GET)
    public ResponseJson current(HttpServletRequest request){
        String token = request.getHeader(UserTokenManager.DEFAULT_TOKEN_NAME);
        return ResponseJson.success(userService.getCurrent(token));
    }
}
