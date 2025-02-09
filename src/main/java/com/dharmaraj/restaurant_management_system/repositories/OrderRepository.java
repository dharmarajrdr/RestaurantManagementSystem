package com.dharmaraj.restaurant_management_system.repositories;

import com.dharmaraj.restaurant_management_system.models.Order;

import java.util.List;

public interface OrderRepository {

    Order save(Order order);

    List<Order> findOrdersByCustomerSession(long customerSessionId);
}
