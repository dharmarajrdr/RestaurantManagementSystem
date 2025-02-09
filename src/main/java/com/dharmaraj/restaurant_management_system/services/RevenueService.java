package com.dharmaraj.restaurant_management_system.services;

import com.dharmaraj.restaurant_management_system.custom_exception.NoStrategyFound;
import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.models.AggregatedRevenue;

public interface RevenueService {
    
    public AggregatedRevenue calculateRevenue(long userId, String queryType) throws UnauthorizedAccessException, UserNotFoundException, NoStrategyFound;
}

