package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDao {
    @Autowired
    UserRepository userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
