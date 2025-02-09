package com.dharmaraj.restaurant_management_system.strategies;

import java.util.Calendar;

import com.dharmaraj.restaurant_management_system.models.DateRange;

public interface AggregatedRevenueCalculator {
    
    public DateRange getDateRange(Calendar calendar);
}
