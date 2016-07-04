package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean canLogUser(User u) {
        Optional<User> fetched = repository.getByUsername(u.getUsername());
        return fetched.isPresent() && fetched.get().getPassword().equals(u.getPassword());
    }

    public User add(User u) {
        return repository.add(u);
    }
}
