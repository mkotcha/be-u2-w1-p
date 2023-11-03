package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;

import java.util.List;
import java.util.UUID;

public interface StationDao {
    public void save(Station station);

    public Station findById(UUID id);

    List<Station> findAll();

    List<Station> findByTypeAndCity(StationType type, String city);

    Station getRandStation();
}
