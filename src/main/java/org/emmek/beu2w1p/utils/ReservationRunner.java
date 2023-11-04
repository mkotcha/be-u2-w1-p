package org.emmek.beu2w1p.utils;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.emmek.beu2w1p.dao.BuildingDao;
import org.emmek.beu2w1p.dao.ReservationDao;
import org.emmek.beu2w1p.dao.StationDao;
import org.emmek.beu2w1p.dao.UserDao;
import org.emmek.beu2w1p.entities.Building;
import org.emmek.beu2w1p.entities.Reservation;
import org.emmek.beu2w1p.entities.Station;
import org.emmek.beu2w1p.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class ReservationRunner implements CommandLineRunner {
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private StationDao stationDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ReservationDao reservationDao;

    @Override
    public void run(String... args) throws Exception {
//        stationDao.findByTypeAndCity(StationType.MEETINGROOM, "Pescara").forEach(System.out::println);
//        stationDao.findAll().forEach(System.out::println);
//        stationDao.findByType(StationType.PRIVATE).forEach(System.out::println);
//        stationDao.findByBuildingCity("Pescara").forEach(System.out::println);
//        stationDao.findByTypeAndBuildingCity(StationType.PRIVATE, "Pescara").forEach(System.out::println);
//        stationDao.getAvailable(LocalDate.now()).forEach(System.out::println);
        Station station = stationDao.getRandStation();
        if (stationDao.isAvailable(station, LocalDate.now())) {
            Reservation reservation = Reservation.builder()
                    .station(station)
                    .user(userDao.getRandUser())
                    .date(LocalDate.now()).build();
            reservationDao.save(reservation);
            log.info("Reservation \n" + reservation + "\ncreated");
        } else {
            log.info("Station " + station.getId() + " is not available");
        }
    }

    void buildDb() {


        Faker faker = new Faker();
        Building building;
        Station station;
        User user;
        Reservation reservation;
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 10; i++) {
            building = Building.builder().build();
            buildingDao.save(building);
        }

        for (int i = 0; i < 25; i++) {
            building = buildingDao.getRandBuilding();
            station = Station.builder().building(building).build();
            stationDao.save(station);
        }

        for (int i = 0; i < 50; i++) {
            user = User.builder().build();
            userDao.save(user);
        }

        for (int i = 0; i < 120; i++) {
            int days = faker.random().nextInt(0, 8);
            reservation = Reservation.builder()
                    .station(stationDao.getRandStation())
                    .user(userDao.getRandUser())
                    .date(now.plusDays(days)).build();
            reservationDao.save(reservation);
        }


    }

}
