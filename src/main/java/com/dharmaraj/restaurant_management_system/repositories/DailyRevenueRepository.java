package com.dharmaraj.restaurant_management_system.repositories;

import java.util.Date;
import java.util.List;

import com.dharmaraj.restaurant_management_system.models.DailyRevenue;

public interface DailyRevenueRepository {
    
    public DailyRevenue save(DailyRevenue dailyRevenue);
    public List<DailyRevenue> getDailyRevenueBetweenDates(Date startDate, Date endDate);
}
