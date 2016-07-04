package com.example.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> database = new ArrayList<>();

    public Optional<User> getByUsername(String username){
        return database.stream()
                .filter(u->u.getUsername().equals(username))
                .findFirst();
    }

    public User add(User u){
        database.add(u);
        return u;
    }
}
