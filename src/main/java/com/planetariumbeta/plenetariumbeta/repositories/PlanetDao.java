package com.planetariumbeta.plenetariumbeta.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.planetariumbeta.plenetariumbeta.entities.Planet;

public interface PlanetDao extends JpaRepository<Planet, Integer>{
    
    Optional<Planet> findByPlanetname(String planetName);

    @Transactional
    @Modifying
    @Query(value = "insert into planets values (default, :name, :ownerid)", nativeQuery = true)
    void createPlanet(@Param("name") String planetName, @Param("ownerid") int ownerId);


}
