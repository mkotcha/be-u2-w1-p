package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.User;

public interface UserDao {
    public void save(User user);

    public User getRandUser();
}
