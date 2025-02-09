package com.dharmaraj.restaurant_management_system.repositories;

import com.dharmaraj.restaurant_management_system.models.Bill;

import java.util.Optional;

public interface BillRepository {
    Bill save(Bill bill);
    Optional<Bill> findById(long billId);
}