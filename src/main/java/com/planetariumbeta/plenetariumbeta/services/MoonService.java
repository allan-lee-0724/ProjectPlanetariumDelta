package com.planetariumbeta.plenetariumbeta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetariumbeta.plenetariumbeta.entities.Moon;
import com.planetariumbeta.plenetariumbeta.exceptions.EntityNotFound;
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
            throw new EntityNotFound("NOT FOUND. PLEASE TRY AGAIN");
        }
    }

    public Moon getMoonByName(String moonName){
        Optional<Moon> possibleMoon = this.moonDao.findByMoonName(moonName);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        } else{
            throw new EntityNotFound("NOT FOUND. PLEASE TRY AGAIN");
        }
    }

    public Moon getMoonById(int moonId){
        Optional<Moon> possibleMoon = this.moonDao.findById(moonId);
        if(possibleMoon.isPresent()){
            return possibleMoon.get();
        } else{
            throw new EntityNotFound("NOT FOUND. PLEASE TRY AGAIN");
        }
    }

    public String createMoon(Moon moon){
        this.moonDao.createMoon(moon.getMoonId(), moon.getMoonName(), moon.getMyPlanetId());
        return "NEW MOON SUCCESSFULLY CREATED";
    }

    public String deleteMoonById(int moonId){
        this.moonDao.deleteById(moonId);
        return "MOON SUCCESSFULLY DELETED";
    }

    public List<Moon> getMoonsFromPlanet(int myPlanetId){
        List<Moon> possibleMoons = this.moonDao.findByMyPlanetId(myPlanetId);
        if(possibleMoons.size() != 0){
            return possibleMoons;
        } else{
            throw new EntityNotFound("NOT FOUND. PLEASE TRY AGAIN");
        }
        
    }

    // public String createMoonsTable(){
    //     this.moonDao.createMoonsTable();
    //     return "NEW MOONS TABLE SUCCESSFULLY CREATED";
    // }

    // public String dropMoonsTable(){
    //     this.moonDao.dropMoonsTable();
    //     return "MOONS TABLE SUCCESSFULLY DELETED";
    // }

}
