package com.thirteen.core.interceptor;

import com.github.pagehelper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Author: rsq0113
 * Date: 2018-09-01 14:36
 * Description:
 **/
public class CORSInterceptor implements HandlerInterceptor {
    private static final String ALLOW_ORIGIN = "*";
    private static final String ALLOW_METHODS = "GET,POST,PUT,DELETE,OPTIONS";
    private static final String ALLOW_CREDENTIALS = "true";
    private static final String ALLOW_HEADERS = "Content-Type,X-Token";
    private static final String EXPOSE_HEADERS = "";
    private Logger logger = LoggerFactory.getLogger(CORSInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*该方法将在请求处理之前进行调用，只有该方法返回true，
        才会继续执行后续的Interceptor和Controller，
        当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
        如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；*/
        logger.debug("CORSInterceptor:preHandle");
        String currentOrigin = request.getHeader("Origin");
        logger.debug("currentOrigin : " + currentOrigin);
        if (StringUtil.isNotEmpty(ALLOW_ORIGIN)) {
            List<String> allowOriginList = Arrays
                    .asList(ALLOW_ORIGIN.split(","));
            logger.debug("allowOriginList : " + ALLOW_ORIGIN);
                if ("*".equals(allowOriginList.get(0))||allowOriginList.contains(currentOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin",
                            currentOrigin);
                }
        }
        if (StringUtil.isNotEmpty(ALLOW_METHODS)) {
            response.setHeader("Access-Control-Allow-Methods", ALLOW_METHODS);
        }
        if (StringUtil.isNotEmpty(ALLOW_CREDENTIALS)) {
            response.setHeader("Access-Control-Allow-Credentials",
                    ALLOW_CREDENTIALS);
        }
        if (StringUtil.isNotEmpty(ALLOW_HEADERS)) {
            response.setHeader("Access-Control-Allow-Headers", ALLOW_HEADERS);
        }
        if (StringUtil.isNotEmpty(EXPOSE_HEADERS)) {
            response.setHeader("Access-Control-Expose-Headers", EXPOSE_HEADERS);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
        可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。*/

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /*该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
        该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。*/

    }
}
