package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
    @Query("SELECT s FROM Station s WHERE s.type = :type AND s.building.city = :city")
    List<Station> findByTypeAndCity(@Param("type") StationType type, @Param("city") String city);


    List<Station> findAll();
}
