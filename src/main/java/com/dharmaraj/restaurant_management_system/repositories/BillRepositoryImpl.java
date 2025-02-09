package com.dharmaraj.restaurant_management_system.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.models.Bill;

public class BillRepositoryImpl implements BillRepository {

    private static Map<Long, Bill> allBills = new HashMap<Long, Bill>();

    @Override
    public Bill save(Bill bill) {
        
        long billId = bill.getId();
        allBills.put(billId, bill);
        return bill;
    }

    @Override
    public Optional<Bill> findById(long billId) {
        
        return Optional.ofNullable(allBills.get(billId));
    }
    
}
