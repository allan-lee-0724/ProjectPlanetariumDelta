package com.planetariumbeta.plenetariumbeta.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.planetariumbeta.plenetariumbeta.entities.Planet;

public interface PlanetDao extends JpaRepository<Planet, Integer>{
    
    Optional<Planet> findByPlanetName(String planetName);

    @Transactional
    @Modifying
    @Query(value = "insert into planets values (:id, :name, :ownerid)", nativeQuery = true)
    void createPlanet(@Param("id") int planetId, @Param("name") String planetName, @Param("ownerid") int ownerId);


    // @Transactional
    // @Modifying
    // @Query(value = "create table planets (id serial primary key, name varchar(20), ownerid int references users(id) on delete cascade", nativeQuery = true)
    // void createPlanetsTable();


    // @Transactional
    // @Modifying
    // @Query(value = "drop table planets cascade", nativeQuery = true)
    // void dropPlanetsTable();
}
