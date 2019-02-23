package com.lg.core;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @类名称: WebLogAspect
 * @作者: 段大神经
 * @创建时间: 2018/10/11 11:23
 * @说明: aop；拦截请求日志
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
	@Pointcut("execution(public * com.lg.*.controller..*.*(..))")
	public void webLog() {
	}
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        StringBuffer param_names = new StringBuffer();
        StringBuffer param_values = new StringBuffer();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
            param_names.append(","+name);
            param_values.append(","+request.getParameter(name));
            log.info("name:{},value:{}", name, request.getParameter(name));
		}
	}
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
	}
	
}
