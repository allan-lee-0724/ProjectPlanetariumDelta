package com.planetariumbeta.plenetariumbeta.exceptions;

public class AuthenticationFailed extends RuntimeException{
    
    public AuthenticationFailed(String message){
        super(message);
    }

}
