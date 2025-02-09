package com.dharmaraj.restaurant_management_system.controllers;

import com.dharmaraj.restaurant_management_system.custom_exception.NoStrategyFound;
import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.dtos.CalculateRevenueRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.CalculateRevenueResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.ResponseStatus;
import com.dharmaraj.restaurant_management_system.models.AggregatedRevenue;
import com.dharmaraj.restaurant_management_system.services.RevenueService;

public class RevenueController {
    
    private RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    public CalculateRevenueResponseDto calculateRevenue(CalculateRevenueRequestDto requestDto) {

        long userId = requestDto.getUserId();
        String revenueQueryType = requestDto.getRevenueQueryType();
        CalculateRevenueResponseDto calculateRevenueResponseDto = new CalculateRevenueResponseDto();

        try {
            AggregatedRevenue aggregatedRevenue = this.revenueService.calculateRevenue(userId, revenueQueryType);
            calculateRevenueResponseDto.setAggregatedRevenue(aggregatedRevenue);
            calculateRevenueResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UnauthorizedAccessException | UserNotFoundException | NoStrategyFound e) {
            calculateRevenueResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return calculateRevenueResponseDto;
    }
}
