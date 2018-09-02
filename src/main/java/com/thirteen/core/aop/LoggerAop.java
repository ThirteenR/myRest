package com.thirteen.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoggerAop {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAop.class);
	private static final Logger doCtrlLogger = LoggerFactory.getLogger("doCtrl");
	@Pointcut("execution(public * com.thirteen.web.*.*.*(..))")
    public void login() {}
	@Before(value = "login()")
	public void doCtrl(JoinPoint joinPoint) {
		logger.info("doCtrl");
		//记录http请求
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//从request中获取http请求的url/请求的方法类型／响应该http请求的类方法／IP地址／请求中的参数
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
}
