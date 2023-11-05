package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "stations")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "StationBuilder")
@Slf4j
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StationType type;
    @Column(nullable = false)
    private int seats;
    @OneToMany(mappedBy = "station", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Reservation> reservations;
    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Slf4j
    public static class StationBuilder {
        Faker faker = new Faker();
        String description = faker.lorem().sentence();
        StationType type = faker.options().option(StationType.values());
        int seats = faker.number().numberBetween(4, 50);
    }
}
