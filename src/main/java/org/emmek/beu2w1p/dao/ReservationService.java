package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements ReservationDao {

    @Autowired
    private ReservationRepository reservationRepo;

    @Override
    public void save(Reservation reservation) {
        reservationRepo.save(reservation);
    }
}
