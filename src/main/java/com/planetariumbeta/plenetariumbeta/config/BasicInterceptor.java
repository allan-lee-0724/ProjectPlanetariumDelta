package com.planetariumbeta.plenetariumbeta.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BasicInterceptor implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       System.out.println("BASICINTERCEPTOR PREHANDLE EXECUTED");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("BASICINTERCEPTOR POSTHANDLE EXECUTED");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("BASICINTERCEPTOR AFTERCOMPLETION EXECUTED");
        return true;
    }
    
    

}
