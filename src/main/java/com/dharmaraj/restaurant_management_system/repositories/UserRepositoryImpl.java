package com.dharmaraj.restaurant_management_system.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.models.User;

public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> allUsers;

    public UserRepositoryImpl() {
        allUsers = new HashMap<>();
    }

    @Override
    public User save(User user) {
        if(user.getId() == 0) {
            user.setId(allUsers.size() + 1);
        }
        allUsers.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        
        return Optional.ofNullable(allUsers.get(id));
    }
    
}
