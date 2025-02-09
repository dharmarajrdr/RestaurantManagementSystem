package com.dharmaraj.restaurant_management_system.repositories;

import com.dharmaraj.restaurant_management_system.models.CustomerSession;

import java.util.Optional;

public interface CustomerSessionRepository {
    public CustomerSession save(CustomerSession customerSession);

    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId);

}
