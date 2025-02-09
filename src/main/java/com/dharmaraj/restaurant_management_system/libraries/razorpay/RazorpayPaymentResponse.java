package com.dharmaraj.restaurant_management_system.libraries.razorpay;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RazorpayPaymentResponse {
    
    private String transactionId;
    private String paymentStatus;
    private String orderId;
    private double transactionAmount;
    private Date transactionDate;
}
