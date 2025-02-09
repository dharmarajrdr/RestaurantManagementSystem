package com.dharmaraj.restaurant_management_system.adapters;

import com.dharmaraj.restaurant_management_system.libraries.razorpay.RazorpayApi;
import com.dharmaraj.restaurant_management_system.libraries.razorpay.RazorpayPaymentResponse;
import com.dharmaraj.restaurant_management_system.models.Payment;
import com.dharmaraj.restaurant_management_system.models.PaymentStatus;

public class RazorpayApiAdapter implements PaymentGatewayAdapter {
    
    private RazorpayApi razorpayApi = new RazorpayApi();

    @Override
    public Payment makePayment(long billId, double amount) {
        RazorpayPaymentResponse response = this.razorpayApi.processPayment(billId, amount);
        Payment payment = new Payment();
        payment.setBillId(billId);
        payment.setPaymentStatus(PaymentStatus.valueOf(response.getPaymentStatus()));
        payment.setTxnId(response.getTransactionId());
        return payment;
    }
}
