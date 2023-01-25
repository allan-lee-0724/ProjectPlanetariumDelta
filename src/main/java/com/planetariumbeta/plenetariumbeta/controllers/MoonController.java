package com.planetariumbeta.plenetariumbeta.controllers;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.planetariumbeta.plenetariumbeta.entities.Moon;
import com.planetariumbeta.plenetariumbeta.exceptions.AuthenticationFailed;
import com.planetariumbeta.plenetariumbeta.exceptions.EntityNotFound;
import com.planetariumbeta.plenetariumbeta.services.MoonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MoonController {

    private static Logger moonLogger = LoggerFactory.getLogger(MoonController.class);
    
    @Autowired
    private MoonService moonService;

    @ExceptionHandler(AuthenticationFailed.class)
    public ResponseEntity<String> authenticationFailed(AuthenticationFailed e){
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e){
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<String> sqlIssue(PSQLException e){
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> deleteFailed(EmptyResultDataAccessException e){
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("api/moons")
    public ResponseEntity<List<Moon>> getAllMoons(){
        return new ResponseEntity<>(this.moonService.getAllMoons(), HttpStatus.OK);
    }

    @GetMapping("api/moon/{name}")
    public ResponseEntity<Moon> getMoonByName(@PathVariable("name") String moonName){
        return new ResponseEntity<>(this.moonService.getMoonByName(moonName), HttpStatus.OK);
    }

    @GetMapping("api/moon/id/{id}")
    public ResponseEntity<Moon> getMoonById(@PathVariable("id") int moonId){
        return new ResponseEntity<>(this.moonService.getMoonById(moonId), HttpStatus.OK);
    }

    @PostMapping("api/{ownerid}/moon")
    public ResponseEntity<String> createMoon(@RequestBody Moon moon, @PathVariable("ownerid") int ownerId) {
        return new ResponseEntity<>(this.moonService.createMoon(moon), HttpStatus.OK);
    }

    @DeleteMapping("api/moon/id/{id}")
    public ResponseEntity<String> deleteMoonById(@PathVariable("id") int moonId){
        return new ResponseEntity<>(this.moonService.deleteMoonById(moonId), HttpStatus.OK);
    }

    @GetMapping("api/{myplanetid}/moons")
    public ResponseEntity<List<Moon>> getMoonsByPlanetId(@PathVariable("myplanetid") int myPlanetId){
        return new ResponseEntity<>(this.moonService.getMoonsFromPlanet(myPlanetId), HttpStatus.OK);
    }
    
    // @PostMapping("api/moons")
    // public ResponseEntity<String> createMoonsTable(){
    //     return new ResponseEntity<>(this.moonService.createMoonsTable(), HttpStatus.CREATED);
    // }

    // @DeleteMapping("api/moons")
    // public ResponseEntity<String> dropMoonsTable(){
    //     return new ResponseEntity<>(this.moonService.dropMoonsTable(), HttpStatus.ACCEPTED);
    // }
    

}
