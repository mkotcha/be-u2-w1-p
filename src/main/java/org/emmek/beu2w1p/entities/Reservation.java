package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor


@IdClass(ReservationId.class)
public class Reservation {
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    private LocalDate date;
}