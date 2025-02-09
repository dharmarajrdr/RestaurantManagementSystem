package com.dharmaraj.restaurant_management_system.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.models.CustomerSession;

public class CustomerSessionRepositoryImpl implements CustomerSessionRepository {

    private static final Map<Long, CustomerSession> customerSessionByUserId = new HashMap<>();
    private static int customerSessionId = 0;

    @Override
    public CustomerSession save(CustomerSession customerSession) {

        if (customerSession.getId() == 0) {
            customerSession.setId(++customerSessionId);
        }
        long userId = customerSession.getUser().getId();
        customerSessionByUserId.put(userId, customerSession);
        return customerSession;
    }

    @Override
    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId) {
        return (customerSessionByUserId.containsKey(userId) && customerSessionByUserId.get(userId).isActiveSession())
                ? Optional.of(customerSessionByUserId.get(userId))
                : Optional.empty();
    }

}
