package org.emmek.beu2w1p.utils;

import lombok.extern.slf4j.Slf4j;
import org.emmek.beu2w1p.dao.BuildingDao;
import org.emmek.beu2w1p.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReservationRunner implements CommandLineRunner {
    @Autowired
    private BuildingDao buildingDao;

    @Override
    public void run(String... args) throws Exception {
        Building building = Building.builder().build();
        buildingDao.save(building);
    }
}
