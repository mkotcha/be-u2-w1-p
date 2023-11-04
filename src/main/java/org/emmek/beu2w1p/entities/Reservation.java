package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ReservationId.class)
@Builder
public class Reservation {
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @Id
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Id
    private LocalDate date;
}