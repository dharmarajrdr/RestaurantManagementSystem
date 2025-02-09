package com.dharmaraj.restaurant_management_system.dtos;

import com.dharmaraj.restaurant_management_system.models.AggregatedRevenue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRevenueResponseDto {
    
    private AggregatedRevenue aggregatedRevenue;
    private ResponseStatus responseStatus;
}
