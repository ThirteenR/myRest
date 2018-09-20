package com.thirteen.core.interceptor;

import com.thirteen.core.norm.JWTManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: rsq0113
 * Date: 2018-09-03 15:12
 * Description:
 **/
public class UValidationInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(UValidationInterceptor.class);
    private static final String LOGIN_FLAG = "/login";
    @Resource
    private JWTManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     /*   String requestURI = request.getRequestURI();
        String token = request.getHeader(UserTokenManager.DEFAULT_TOKEN_NAME);
        if (!tokenManager.checkToken(token)){
            if (requestURI.endsWith(LOGIN_FLAG)){
                return true;
            }
            logger.debug("用户Token验证失败："+token);
            throw new ConstException(ResponseEnum.NOT_LOGIN,"用户Token验证失败："+token);
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
