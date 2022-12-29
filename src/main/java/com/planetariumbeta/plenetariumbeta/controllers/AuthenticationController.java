package com.planetariumbeta.plenetariumbeta.controllers;

import javax.servlet.http.HttpSession;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planetariumbeta.plenetariumbeta.entities.User;
import com.planetariumbeta.plenetariumbeta.services.UserService;



@RestController
public class AuthenticationController {

    private static Logger userLogger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private UserService userService;
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> duplicateUser(DataIntegrityViolationException e){
        userLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>("USERNAME ALREADY IN USE. PLEASE CHANGE YOUR USERNAME", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<String> duplicateUserPSQL(PSQLException e){
        userLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>("USERNAME ALREADY IN USE. PLEASE CHANGE YOUR USERNAME", HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/login")
    public String login(HttpSession session, @RequestBody User user){
        session.setAttribute("username", user.getUsername());
        session.setAttribute("password", user.getPassword());
        return "LOGGED IN SUCCESSFULLY";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "LOGGED OUT SUCCESSFULLY";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        return new ResponseEntity<>(this.userService.register(user), HttpStatus.ACCEPTED);
    }

    

}
