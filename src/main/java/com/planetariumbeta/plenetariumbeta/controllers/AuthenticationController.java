package com.planetariumbeta.plenetariumbeta.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthenticationController {
    
    @PostMapping("/api/login")
    public String login(HttpSession session){
        session.setAttribute("username", "username");
        session.setAttribute("password", "password");
        return "LOGGED IN SUCCESSFULLY";
    }

    @PostMapping("/api/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "LOGGED OUT SUCCESSFULLY";
    }

    

}
