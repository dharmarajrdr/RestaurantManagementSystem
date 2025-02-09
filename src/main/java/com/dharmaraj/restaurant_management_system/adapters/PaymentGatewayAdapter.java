package com.dharmaraj.restaurant_management_system.adapters;

import com.dharmaraj.restaurant_management_system.models.Payment;

public interface PaymentGatewayAdapter {

    Payment makePayment(long billId, double amount);
}