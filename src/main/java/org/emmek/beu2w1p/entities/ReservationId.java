package org.emmek.beu2w1p.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationId implements Serializable {
    private User user;
    private LocalDate date;

}
