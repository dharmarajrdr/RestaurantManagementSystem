package com.dharmaraj.restaurant_management_system.adapters;

import com.dharmaraj.restaurant_management_system.libraries.paytm.PaytmApi;
import com.dharmaraj.restaurant_management_system.libraries.paytm.PaytmPaymentResponse;
import com.dharmaraj.restaurant_management_system.models.Payment;
import com.dharmaraj.restaurant_management_system.models.PaymentStatus;

public class PaytmApiAdapter implements PaymentGatewayAdapter {
    
    private PaytmApi paytmApi = new PaytmApi();

    @Override
    public Payment makePayment(long billId, double amount) {
        PaytmPaymentResponse response = this.paytmApi.makePayment(billId, amount);
        Payment payment = new Payment();
        payment.setBillId(billId);
        payment.setPaymentStatus(PaymentStatus.valueOf(response.getPaymentStatus()));
        payment.setTxnId(response.getTxnId());
        return payment;
    }
}
