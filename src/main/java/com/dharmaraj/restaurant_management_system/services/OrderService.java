package com.dharmaraj.restaurant_management_system.services;

import com.dharmaraj.restaurant_management_system.custom_exception.CustomerSessionNotFound;
import com.dharmaraj.restaurant_management_system.models.Bill;


public interface OrderService {

    public Bill generateBill(long userId) throws CustomerSessionNotFound;
}
