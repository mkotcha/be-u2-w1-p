package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.Reservation;
import org.emmek.beu2w1p.entities.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {


}
