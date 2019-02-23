package com.lg.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 产生异常后启动类
 * 首先GlobalExceptionHandler定义此类为出现异常后调用类
 * @author 段大神经
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	// @ExceptionHandler   加这个 注解   runtimeexception.class表示所有运行时错误
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, Object> ExceptionHandler(){
		Map<String,Object> result = new HashMap<String,Object>() ;
		result.put("code", "系统错误");
		result.put("msg", "程序员正在努力抢修！！！");
		return result;
	}
}
