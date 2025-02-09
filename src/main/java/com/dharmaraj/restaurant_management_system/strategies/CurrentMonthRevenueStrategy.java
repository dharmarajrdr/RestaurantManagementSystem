package com.dharmaraj.restaurant_management_system.strategies;

import java.util.Calendar;
import java.util.Date;

import com.dharmaraj.restaurant_management_system.models.DateRange;

public class CurrentMonthRevenueStrategy implements AggregatedRevenueCalculator {

    @Override
    public DateRange getDateRange(Calendar calendar) {
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();
        return new DateRange(startDate, endDate);
    }   
}
