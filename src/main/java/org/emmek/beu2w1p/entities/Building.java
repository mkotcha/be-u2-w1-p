package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.*;
import net.datafaker.Faker;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "BuildingBuilder")
public class Building {
    @OneToMany(mappedBy = "building", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    List<Station> stations;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public static class BuildingBuilder {
        Faker faker = new Faker();
        String name = faker.address().streetName();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
    }

}
