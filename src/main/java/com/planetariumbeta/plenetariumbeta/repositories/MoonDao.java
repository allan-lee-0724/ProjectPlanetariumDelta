package com.planetariumbeta.plenetariumbeta.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.planetariumbeta.plenetariumbeta.entities.Moon;

public interface MoonDao extends JpaRepository<Moon, Integer> {
    
    Optional<Moon> findByMoonName(String moonName);
    
    @Transactional
    @Query(value = "select * from moons where myplanetid = :myplanetid", nativeQuery = true)
    List<Moon> findByMyPlanetId(@Param("myplanetid") int myPlanetId);

    @Transactional
    @Modifying
    @Query(value = "insert into moons values (:id, :name, :myplanetid)", nativeQuery = true)
    void createMoon(@Param("id") int moonId, @Param("name") String moonName, @Param("myplanetid") int myPlanetId);


    // @Transactional
    // @Modifying
    // @Query(value = "create table moons (id serial primary key, name varchar(20), myplanetid int references planets(id) on delete cascade")
    // void createMoonsTable();


    // @Transactional
    // @Modifying
    // @Query(value = "drop table moons cascade")
    // void dropMoonsTable();
}
