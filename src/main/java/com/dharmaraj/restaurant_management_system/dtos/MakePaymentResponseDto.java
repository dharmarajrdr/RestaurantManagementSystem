package com.dharmaraj.restaurant_management_system.dtos;

import com.dharmaraj.restaurant_management_system.models.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentResponseDto {
    
    private ResponseStatus responseStatus;
    private String txnId;
    private PaymentStatus paymentStatus;
}
