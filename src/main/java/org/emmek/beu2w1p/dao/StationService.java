package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.StationType;
import org.emmek.beu2w1p.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return stationRepo.findAll();
    }

    @Override
    public List<Station> findByTypeAndCity(StationType type, String city) {
        return stationRepo.findByTypeAndCity(type, city);
    }

    @Override
    public Station getRandStation() {
        return stationRepo.getRandStation();
    }

    @Override
    public List<Station> findByType(StationType type) {
        return stationRepo.findByType(type);
    }

    @Override
    public List<Station> findByBuildingCity(String city) {
        return stationRepo.findByBuildingCity(city);
    }

    @Override
    public List<Station> findByTypeAndBuildingCity(StationType type, String city) {
        return stationRepo.findByTypeAndBuildingCity(type, city);
    }

    @Override
    public List<Station> getAvailable(LocalDate date) {
        return stationRepo.getAvailable(date);
    }

    @Override
    public boolean isAvailable(Station station, LocalDate now) {
        return stationRepo.isAvailable(station, now);
    }


}
