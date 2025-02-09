package com.dharmaraj.restaurant_management_system.controllers;

import com.dharmaraj.restaurant_management_system.custom_exception.InvalidBillException;
import com.dharmaraj.restaurant_management_system.dtos.MakePaymentRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.MakePaymentResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.ResponseStatus;
import com.dharmaraj.restaurant_management_system.models.Payment;
import com.dharmaraj.restaurant_management_system.models.PaymentStatus;
import com.dharmaraj.restaurant_management_system.services.PaymentService;

public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) {
        
        long billId = makePaymentRequestDto.getBillId();
        MakePaymentResponseDto makePaymentResponseDto = new MakePaymentResponseDto();
        try {
            Payment payment = this.paymentService.makePayment(billId);
            String tnxId = payment.getTxnId();
            makePaymentResponseDto.setPaymentStatus(PaymentStatus.SUCCESS);
            makePaymentResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            makePaymentResponseDto.setTxnId(tnxId);
        } catch(InvalidBillException e) {
            makePaymentResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return makePaymentResponseDto;
    }
}