package org.emmek.beu2w1p.utils;

import lombok.extern.slf4j.Slf4j;
import org.emmek.beu2w1p.dao.BuildingDao;
import org.emmek.beu2w1p.dao.StationDao;
import org.emmek.beu2w1p.entities.Building;
import org.emmek.beu2w1p.entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReservationRunner implements CommandLineRunner {
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private StationDao stationDao;

    @Override
    public void run(String... args) throws Exception {
//        Building building = Building.builder().build();
//        buildingDao.save(building);
        Building building = buildingDao.getRandBuilding();
        Station station = Station.builder().building(building).build();
        stationDao.save(station);

    }

}
