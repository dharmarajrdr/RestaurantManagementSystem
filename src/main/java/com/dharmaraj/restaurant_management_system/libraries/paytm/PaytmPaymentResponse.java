package com.dharmaraj.restaurant_management_system.libraries.paytm;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaytmPaymentResponse {
    
    private String txnId;
    private String paymentStatus;
    private String orderId;
    private double txnAmount;
    private Date txnDate;
}
