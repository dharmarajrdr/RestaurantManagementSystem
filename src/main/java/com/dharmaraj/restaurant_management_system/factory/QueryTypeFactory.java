package com.dharmaraj.restaurant_management_system.factory;

import com.dharmaraj.restaurant_management_system.custom_exception.NoStrategyFound;
import com.dharmaraj.restaurant_management_system.models.RevenueQueryType;
import com.dharmaraj.restaurant_management_system.strategies.AggregatedRevenueCalculator;
import com.dharmaraj.restaurant_management_system.strategies.CurrentFinancialYearStrategy;
import com.dharmaraj.restaurant_management_system.strategies.CurrentMonthRevenueStrategy;
import com.dharmaraj.restaurant_management_system.strategies.PreviousFinancialYearRevenueStrategy;
import com.dharmaraj.restaurant_management_system.strategies.PreviousMonthRevenueStrategy;

public class QueryTypeFactory {
    
    public static AggregatedRevenueCalculator getAggregatedRevenueCalculator(RevenueQueryType revenueQueryType) throws NoStrategyFound {
        switch(revenueQueryType) {
            case CURRENT_MONTH: {
                return new CurrentMonthRevenueStrategy();
            }
            case CURRENT_FY: {
                return new CurrentFinancialYearStrategy();
            }
            case PREVIOUS_MONTH: {
                return new PreviousMonthRevenueStrategy();
            }
            case PREVIOUS_FY: {
                return new PreviousFinancialYearRevenueStrategy();
            }
        }
        throw new NoStrategyFound("No Strategy found for queryType '" + revenueQueryType.toString() + "'.");
    }
}
