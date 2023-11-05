package org.emmek.beu2w1p.entities;

import jakarta.persistence.*;
import lombok.*;
import net.datafaker.Faker;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "UserBuilder")
public class User {
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    List<Reservation> reservations;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    public static class UserBuilder {
        Faker faker = new Faker();
        String userName = faker.internet().username();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
    }


}
