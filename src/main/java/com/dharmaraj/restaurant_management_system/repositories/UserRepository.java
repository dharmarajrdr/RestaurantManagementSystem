package com.dharmaraj.restaurant_management_system.repositories;

import com.dharmaraj.restaurant_management_system.models.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(long id);
}
