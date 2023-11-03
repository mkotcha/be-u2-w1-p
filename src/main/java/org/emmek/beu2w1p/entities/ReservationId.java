package org.emmek.beu2w1p.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@EqualsAndHashCode
public class ReservationId implements Serializable {
    private User user;
    private LocalDate date;


}
