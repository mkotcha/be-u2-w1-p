package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType type;
    private int seats;
    @OneToMany(mappedBy = "station")
    @ToString.Exclude
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
