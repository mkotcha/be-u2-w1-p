package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    List<Station> stations;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String address;
    private String city;

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }


}
