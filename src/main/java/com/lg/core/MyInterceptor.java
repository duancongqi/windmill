package com.lg.core;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @类名称：MyInterceptor
 * @作者: 段大神经
 * @创建时间: 2018/9/29 22:03
 * @说明: 拦截器类
 */
//@Component
public class MyInterceptor implements HandlerInterceptor {
/*
    @Value("${yqb.yzdz}")
    private String yzdz;
    @Value("${yqb.yzsh}")
    private boolean yzsh;*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object login_user = request.getSession().getAttribute("");
        if (login_user == null) {
            response.sendRedirect("");
            return false;
        }
        return true;
    }


}
