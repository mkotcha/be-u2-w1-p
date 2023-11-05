package org.emmek.beu2w1p.dao;

import org.emmek.beu2w1p.entities.User;
import org.emmek.beu2w1p.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserDao {
    @Autowired
    UserRepository userRepo;

    @Override
    public User findById(UUID id) throws ItemNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User getRandUser() {
        return userRepo.getRandUser();
    }
}
