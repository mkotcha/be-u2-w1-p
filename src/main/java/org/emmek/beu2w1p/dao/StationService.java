package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;
import org.emmek.beu2w1p.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StationService implements StationDao {

    @Autowired
    private StationRepository stationRepo;

    @Override
    public void save(Station station) {
        stationRepo.save(station);
    }

    @Override
    public Station findById(UUID id) throws ItemNotFoundException {
        return stationRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public List<Station> findByTypeAndCity(StationType type, String city) {
        return stationRepo.findByTypeAndCity(type, city);
    }
}
