package com.planetariumbeta.plenetariumbeta.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.planetariumbeta.plenetariumbeta.exceptions.AuthenticationFailed;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null){
            return true;
        } else{
            throw new AuthenticationFailed("PLEASE LOGIN BEFORE INTERACTING WITH APPLICATION");
        }
    }
    
    

}
