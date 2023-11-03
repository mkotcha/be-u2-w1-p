package org.emmek.beu2w1p.entities;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
public class ReservationId implements Serializable {
    private User user;
    private LocalDate date;

}
