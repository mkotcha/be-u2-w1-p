package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Building;
import org.emmek.beu2w1p.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingService implements BuildingDao {
    @Autowired
    private BuildingRepository buildingRepo;

    @Override
    public void save(Building building) {
        buildingRepo.save(building);
    }

    @Override
    public Building findById(UUID id) throws ItemNotFoundException {
        return buildingRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public List<Building> findByCity(String city) {
        return null;
    }

    @Override
    public Building getRandBuilding() {
        return buildingRepo.getRandBuilding();
    }


}
