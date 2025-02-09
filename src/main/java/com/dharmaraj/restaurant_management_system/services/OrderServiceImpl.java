package com.dharmaraj.restaurant_management_system.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.custom_exception.CustomerSessionNotFound;
import com.dharmaraj.restaurant_management_system.models.Bill;
import com.dharmaraj.restaurant_management_system.models.CustomerSession;
import com.dharmaraj.restaurant_management_system.models.CustomerSessionStatus;
import com.dharmaraj.restaurant_management_system.models.MenuItem;
import com.dharmaraj.restaurant_management_system.models.Order;
import com.dharmaraj.restaurant_management_system.repositories.CustomerSessionRepository;
import com.dharmaraj.restaurant_management_system.repositories.OrderRepository;

public class OrderServiceImpl implements OrderService {

    private CustomerSessionRepository customerSessionRepository;
    private OrderRepository orderRepository;

    public OrderServiceImpl(CustomerSessionRepository customerSessionRepository, OrderRepository orderRepository) {
        this.customerSessionRepository = customerSessionRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Bill generateBill(long userId) throws CustomerSessionNotFound {

        Optional<CustomerSession> optionalCustomerSession = this.customerSessionRepository
                .findActiveCustomerSessionByUserId(userId);
        if (optionalCustomerSession.isEmpty()) {
            throw new CustomerSessionNotFound("Customer session not found");
        }

        CustomerSession customerSession = optionalCustomerSession.get();

        double totalAmount = 0;

        Map<MenuItem, Integer> orderedItems = new HashMap<>();

        List<Order> orders = this.orderRepository.findOrdersByCustomerSession(customerSession.getId());
        for (Order order : orders) {

            for (Map.Entry<MenuItem, Integer> entry : order.getOrderedItems().entrySet()) {

                MenuItem menuItem = entry.getKey();
                int quantity = entry.getValue();

                double price = menuItem.getPrice();
                totalAmount += (price * quantity);

                orderedItems.put(menuItem, orderedItems.getOrDefault(menuItem, 0) + quantity);
            }

        }

        double gst = totalAmount * 0.05;
        double serviceCharge = totalAmount * 0.1;

        Bill bill = new Bill();
        bill.setTotalAmount(totalAmount + gst + serviceCharge);
        bill.setGst(gst);
        bill.setServiceCharge(serviceCharge);
        bill.setOrderedItems(orderedItems);
        customerSession.setCustomerSessionStatus(CustomerSessionStatus.ENDED);
        customerSessionRepository.save(customerSession);
        return bill;
    }

}
