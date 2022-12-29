package com.planetariumbeta.plenetariumbeta.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Code500Controller {
    
    @GetMapping("api/code502")
    public ResponseEntity<String> code500(){
        return new ResponseEntity<>("CODE 502 REPORTED", HttpStatus.BAD_GATEWAY);
    }

}
