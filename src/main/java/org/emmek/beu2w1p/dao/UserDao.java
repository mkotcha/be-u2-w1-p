package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.User;

import java.util.UUID;

public interface UserDao {
    public void save(User user);

    public User findById(UUID id);

    public User getRandUser();
}
