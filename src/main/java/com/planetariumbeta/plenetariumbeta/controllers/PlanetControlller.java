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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planetariumbeta.plenetariumbeta.entities.Planet;
import com.planetariumbeta.plenetariumbeta.exceptions.AuthenticationFailed;
import com.planetariumbeta.plenetariumbeta.exceptions.EntityNotFound;
import com.planetariumbeta.plenetariumbeta.services.PlanetService;

@RestController
public class PlanetControlller {
    
    private static Logger planetLogger = LoggerFactory.getLogger(PlanetControlller.class);

    @Autowired
    private PlanetService planetService;

    @ExceptionHandler(AuthenticationFailed.class)
    public ResponseEntity<String> authenticationFailed(AuthenticationFailed e){
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e){
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<String> sqlIssue(PSQLException e){
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> deleteFailed(EmptyResultDataAccessException e){
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @GetMapping("api/planets")
    public ResponseEntity<List<Planet>> getAllPlanets(){
        return new ResponseEntity<>(this.planetService.getAllPlanets(), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @GetMapping("api/planet/{planetName}")
    public ResponseEntity<Planet> getPlanetByName(@PathVariable String planetName){
        return new ResponseEntity<>(this.planetService.getPlanetByName(planetName), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @GetMapping("api/planet/id/{myPlanetId}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable int myPlanetId){
        return new ResponseEntity<>(this.planetService.getPlanetById(myPlanetId), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @PostMapping("api/{ownerId}/planet")
    public ResponseEntity<String> createPlanet(@RequestBody Planet planet, @PathVariable int ownerId){
        return new ResponseEntity<>(this.planetService.createPlanet(planet), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    @DeleteMapping("api/planet/{myPlanetId}")
    public ResponseEntity<String> deletePlanetById(@PathVariable int myPlanetId){
        return new ResponseEntity<>(this.planetService.deletePlanetById(myPlanetId), HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    // @PostMapping("api/moons")
    // public ResponseEntity<String> createPlanetsTable(){
    //     return new ResponseEntity<>(this.planetService.createPlanetsTable(), HttpStatus.CREATED);
    // }

    // @DeleteMapping("api/moons")
    // public ResponseEntity<String> dropPlanetsTable(){
    //     return new ResponseEntity<>(this.planetService.dropPlanetsTable(), HttpStatus.ACCEPTED);
    // }

    

    

}
