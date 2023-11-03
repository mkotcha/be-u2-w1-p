package org.emmek.beu2w1p.utils;

import lombok.extern.slf4j.Slf4j;
import org.emmek.beu2w1p.dao.BuildingDao;
import org.emmek.beu2w1p.dao.StationDao;
import org.emmek.beu2w1p.dao.UserDao;
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
    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
//        Building building = Building.builder().build();
//        buildingDao.save(building);
//        Building building = buildingDao.getRandBuilding();
//        Station station = Station.builder().building(building).build();
//        stationDao.save(station);
//        for (int i = 0; i < 20; i++) {
//            User user = User.builder().build();
//            userDao.save(user);
//        }

    }

}
