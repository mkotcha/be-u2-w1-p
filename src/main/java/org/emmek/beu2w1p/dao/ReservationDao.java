package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Reservation;
import org.emmek.beu2w1p.entities.ReservationId;

public interface ReservationDao {
    public void save(Reservation reservation);

    public Reservation findById(ReservationId id);
}
