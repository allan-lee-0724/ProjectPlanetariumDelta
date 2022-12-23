package com.planetariumbeta.plenetariumbeta.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.planetariumbeta.plenetariumbeta.entities.Moon;

public interface MoonDao extends JpaRepository {
    
    Optional<Moon> findByMoonName(String moonName);

    @Transactional
    @Modifying
    @Query(value = "insert into moons values (default, :name, :myplanetid", nativeQuery = true)
    void createMoon(@Param("name") String moonName, @Param("myplanetid") int myPlanetId);

}
