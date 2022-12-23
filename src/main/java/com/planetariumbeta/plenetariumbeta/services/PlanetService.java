package com.planetariumbeta.plenetariumbeta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetariumbeta.plenetariumbeta.entities.Planet;
import com.planetariumbeta.plenetariumbeta.repositories.PlanetDao;

@Service
public class PlanetService {
    
    @Autowired
    private PlanetDao planetDao;

    public List<Planet> getAllPlanets(){
        List<Planet> planets = this.planetDao.findAll();
        if(planets.size() != 0){
            return planets;
        } else{
            return null;
        }
    }

    public Planet getPlanetByName(String planetName){
        Optional<Planet> possiblePlanet = this.planetDao.findByPlanetName(planetName);
        if(possiblePlanet.isPresent()){
            return possiblePlanet.get();
        }else{
            return null;
        }
    }

}
