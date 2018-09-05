package com.thirteen.core.aop;

import com.thirteen.core.exception.ConstException;
import com.thirteen.core.norm.TokenManager;
import com.thirteen.core.response.ResponseEnum;
import com.thirteen.core.token.UserTokenManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoggerAop {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAop.class);
	private static final Logger doCtrlLogger = LoggerFactory.getLogger("doCtrl");
	private static final String LOGIN_FLAG = "/login";
	@Resource
	private TokenManager tokenManager;
	@Pointcut("execution(public * com.thirteen.web.*.*.*(..))")
    public void login() {}
	@Before(value = "login()")
	public void doCtrl(JoinPoint joinPoint) {
		logger.info("doCtrl");
		//记录http请求
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		matchToken(request);
		//url
		doCtrlLogger.info("[url]={}",request.getRequestURI());

		//method
		doCtrlLogger.info("[method]={}",request.getMethod());

		//ip
		doCtrlLogger.info("[ip]={}",request.getRemoteAddr());

		//类方法
		doCtrlLogger.info("[class_method]={}",joinPoint.getSignature().getDeclaringTypeName()+
				"."+joinPoint.getSignature().getName());

		//参数

		doCtrlLogger.info("[args]={}",joinPoint.getArgs());
	}

	private void matchToken(HttpServletRequest request){
		String requestURI = request.getRequestURI();
		String token = request.getHeader(UserTokenManager.DEFAULT_TOKEN_NAME);
		if (!tokenManager.checkToken(token)){
			if (requestURI.endsWith(LOGIN_FLAG)){
				logger.debug("登录请求，通过："+requestURI);
			}else {
				logger.debug("用户Token验证失败："+token);
				throw new ConstException(ResponseEnum.NOT_LOGIN,"用户Token验证失败："+token);
			}
		}
	}
}
