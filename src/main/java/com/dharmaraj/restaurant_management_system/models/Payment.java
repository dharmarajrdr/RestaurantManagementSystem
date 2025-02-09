package com.dharmaraj.restaurant_management_system.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    
    private String txnId;
    private PaymentStatus paymentStatus;
    private long billId;
}