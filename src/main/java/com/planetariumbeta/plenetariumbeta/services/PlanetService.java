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

    public Planet getPlanetById(int myPlanetId){
        Optional<Planet> possiblePlanet = this.planetDao.findById(myPlanetId);
        if(possiblePlanet.isPresent()){
            return possiblePlanet.get();
        } else{
            return null;
        }
    }

    public String createPlanet(Planet planet){
        this.planetDao.createPlanet(planet.getPlanetId(), planet.getPlanetName(), planet.getOwnerId());
        return "NEW PLANET SUCCESSFULLY CREATED";
    }

    public String deletePlanetById(int myPlanetId){
        this.planetDao.deleteById(myPlanetId);
        return "PLANET SUCCESSFULLY DELETED";
    }
    
    // public String createPlanetsTable(){
    //     this.planetDao.createPlanetsTable();
    //     return "NEW PLANETS TABLE SUCCESSFULLY CREATED";
    // }

    // public String dropPlanetsTable(){
    //     this.planetDao.dropPlanetsTable();
    //     return "PLANETS TABLE SUCCESSFULLY DELETED";
    // }
}
