package org.emmek.beu2w1p;

import org.emmek.beu2w1p.dao.BuildingDao;
import org.emmek.beu2w1p.dao.ReservationDao;
import org.emmek.beu2w1p.dao.StationDao;
import org.emmek.beu2w1p.dao.UserDao;
import org.emmek.beu2w1p.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReservationManagementApplicationTests {


    @Autowired
    UserDao userDao;
    @Autowired
    BuildingDao buildingDao;
    @Autowired
    ReservationDao reservationDao;

    @Autowired
    StationDao stationDao;

    @Test
    void findByIdTest() {
        UUID userId = UUID.fromString("0fc3e33f-18f7-4de1-a39d-23a0156367fe");
        User user = userDao.findById(userId);
        UUID buildingId = UUID.fromString("25250f1d-6fa5-4dff-96e0-5a1cab0fe37b");
        Building building = buildingDao.findById(buildingId);
        ReservationId reservationId = new ReservationId(user, LocalDate.of(2023, 11, 5));
        Reservation reservation = reservationDao.findById(reservationId);
        UUID stationId = UUID.fromString("192c378f-7939-4803-a4b0-8fc314049144");
        Station station = stationDao.findById(stationId);
        assertEquals(userId, user.getId());
        assertEquals(buildingId, building.getId());
        assertAll(
                () -> assertEquals(reservationId.getUser().getId(), reservation.getId().getUser().getId()),
                () -> assertEquals(reservationId.getDate(), reservation.getId().getDate())
        );
        assertEquals(stationId, station.getId());
    }

}
