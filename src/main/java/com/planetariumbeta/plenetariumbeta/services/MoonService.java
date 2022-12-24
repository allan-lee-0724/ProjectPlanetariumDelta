package com.planetariumbeta.plenetariumbeta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetariumbeta.plenetariumbeta.entities.Moon;
import com.planetariumbeta.plenetariumbeta.repositories.MoonDao;

@Service
public class MoonService {
    
    @Autowired
    private MoonDao moonDao;

    public List<Moon> getAllMoons(){
        List<Moon> moons = this.moonDao.findAll();
        if(moons.size() != 0){
            return moons;
        } else{
            return null;
        }
    }

    public Moon getMoonByName(String moonName){
        Optional<Moon> possibleMoon = this.moonDao.findByMoonName(moonName);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        } else{
            return null;
        }
    }

    public Moon getMoonById(int moonId){
        Optional<Moon> possibleMoon = this.moonDao.findById(moonId);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        } else{
            return null;
        }
    }

    public String createMoon(Moon moon){
        this.moonDao.createMoon(moon.getMoonName(), moon.getMyPlanetId());
        return "NEW MOON SUCCESSFULLY CREATED";
    }

    public String deleteMoonById(int moonId){
        this.moonDao.deleteById(moonId);
        return "MOON SUCCESSFULLY DELETED";
    }

    public List<Moon> getMoonsFromPlanet(int myPlanetId){
        List<Moon> possibleMoons = this.moonDao.findMoonsByPlanetId(myPlanetId);
        if(possibleMoons.size() != 0){
            return possibleMoons;
        } else{
            return null;
        }
        
    }

}
