package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {

//    Building findById(String id);

    List<Building> findByCity(String city);

    @Query("SELECT b FROM Building b ORDER BY RANDOM() LIMIT 1")
    Building getRandBuilding();
}
