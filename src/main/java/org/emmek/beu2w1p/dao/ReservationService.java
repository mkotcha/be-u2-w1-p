package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Reservation;
import org.emmek.beu2w1p.entities.ReservationId;
import org.emmek.beu2w1p.exceptions.ItemNotFoundException;
import org.emmek.beu2w1p.exceptions.NotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements ReservationDao {

    @Autowired
    StationDao stationDao;
    @Autowired
    private ReservationRepository reservationRepo;

    @Override
    public void save(Reservation reservation) {

        if (stationDao.isAvailable(reservation.getStation(), reservation.getDate())) {
            reservationRepo.save(reservation);
        } else {
            throw new NotAvailableException(reservation.getStation());
        }
    }

    @Override
    public Reservation findById(ReservationId id) throws ItemNotFoundException {
        return reservationRepo.findById(id).orElseThrow(ItemNotFoundException::new);
    }
}
