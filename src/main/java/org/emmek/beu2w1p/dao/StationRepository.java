package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {
    @Query("SELECT s FROM Station s WHERE s.type = :type AND s.building.city = :city")
    List<Station> findByTypeAndCity(@Param("type") StationType type, @Param("city") String city);

    @Query("SELECT s FROM Station s ORDER BY RANDOM() LIMIT 1")
    Station getRandStation();

    List<Station> findByType(StationType type);

    List<Station> findByBuildingCity(String city);

    List<Station> findByTypeAndBuildingCity(StationType type, String city);

    @Query("SELECT s FROM Station s WHERE s NOT IN (SELECT r.station FROM Reservation r WHERE r.date = :date )")
    List<Station> getAvailable(@Param("date") LocalDate date);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Station s WHERE s = :station AND s NOT IN (SELECT r.station FROM Reservation r WHERE r.date = :date )")
    boolean isAvailable(@Param("station") Station station, @Param("date") LocalDate date);
}
