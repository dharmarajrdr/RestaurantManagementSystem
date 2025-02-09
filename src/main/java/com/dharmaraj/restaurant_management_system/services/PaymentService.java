package com.dharmaraj.restaurant_management_system.services;

import com.dharmaraj.restaurant_management_system.custom_exception.InvalidBillException;
import com.dharmaraj.restaurant_management_system.models.Payment;

public interface PaymentService {

    Payment makePayment(long billId) throws InvalidBillException;
}