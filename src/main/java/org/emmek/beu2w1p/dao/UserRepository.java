package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u ORDER BY RANDOM() LIMIT 1")
    User getRandUser();
}
