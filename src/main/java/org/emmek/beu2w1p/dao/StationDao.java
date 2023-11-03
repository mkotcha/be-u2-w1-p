package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface StationDao {
    public void save(Station station);

    public Station findById(UUID id);

    List<Station> findAll();

    List<Station> findByTypeAndCity(StationType type, String city);

    Station getRandStation();

    List<Station> findByType(StationType type);

    List<Station> findByBuildingCity(String city);

    List<Station> findByTypeAndBuildingCity(StationType type, String city);

    List<Station> getAvailable(LocalDate date);

    boolean isAvailable(Station station, LocalDate now);
}
