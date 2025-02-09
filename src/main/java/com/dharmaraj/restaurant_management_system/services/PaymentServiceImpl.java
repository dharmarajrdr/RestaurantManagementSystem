package com.dharmaraj.restaurant_management_system.services;

import java.util.Optional;

import com.dharmaraj.restaurant_management_system.adapters.PaymentGatewayAdapter;
import com.dharmaraj.restaurant_management_system.custom_exception.InvalidBillException;
import com.dharmaraj.restaurant_management_system.models.Bill;
import com.dharmaraj.restaurant_management_system.models.Payment;
import com.dharmaraj.restaurant_management_system.repositories.BillRepository;

public class PaymentServiceImpl implements PaymentService {

    private BillRepository billRepository;
    private PaymentGatewayAdapter paymentGatewayAdapter;

    public PaymentServiceImpl(BillRepository billRepository, PaymentGatewayAdapter paymentGatewayAdapter) {
        this.billRepository = billRepository;
        this.paymentGatewayAdapter = paymentGatewayAdapter;
    }

    @Override
    public Payment makePayment(long billId) throws InvalidBillException {
        
        Optional<Bill> optionalBill = this.billRepository.findById(billId);
        if(optionalBill.isEmpty()) {
            throw new InvalidBillException("Invalid bill id");
        }

        Bill bill = optionalBill.get();
        double totalAmount = bill.getTotalAmount();
        return this.paymentGatewayAdapter.makePayment(bill.getId(), totalAmount);
    }
    
}
