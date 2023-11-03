package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;

import java.util.List;

public interface StationDao {
    public void save(Station station);

    public Station findById(String id);

    List<Station> findAllAvailable();

    List<Station> findByTypeAndCity(StationType type, String city);
}
