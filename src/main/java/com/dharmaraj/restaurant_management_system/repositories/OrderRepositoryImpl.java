package com.dharmaraj.restaurant_management_system.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dharmaraj.restaurant_management_system.models.Order;

public class OrderRepositoryImpl implements OrderRepository {

    private static final Map<Long, List<Order>> orderByCustomerSessionId = new HashMap<>();
    private static int orderId = 0;

    @Override
    public Order save(Order order) {

        if(order.getId() == 0) {
            order.setId(++orderId);
        }
        long customerSessionId = order.getCustomerSession().getId();
        List<Order> orders = orderByCustomerSessionId.getOrDefault(customerSessionId, new ArrayList<>());
        orders.add(order);
        orderByCustomerSessionId.put(customerSessionId, orders);
        return order;
    }

    @Override
    public List<Order> findOrdersByCustomerSession(long customerSessionId) {
        return orderByCustomerSessionId.getOrDefault(customerSessionId, new ArrayList<>());
    }

}
