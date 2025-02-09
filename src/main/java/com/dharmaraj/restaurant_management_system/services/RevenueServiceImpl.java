package com.dharmaraj.restaurant_management_system.services;


import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.custom_exception.NoStrategyFound;
import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.factory.QueryTypeFactory;
import com.dharmaraj.restaurant_management_system.models.AggregatedRevenue;
import com.dharmaraj.restaurant_management_system.models.DailyRevenue;
import com.dharmaraj.restaurant_management_system.models.DateRange;
import com.dharmaraj.restaurant_management_system.models.RevenueQueryType;
import com.dharmaraj.restaurant_management_system.models.User;
import com.dharmaraj.restaurant_management_system.models.UserType;
import com.dharmaraj.restaurant_management_system.repositories.DailyRevenueRepository;
import com.dharmaraj.restaurant_management_system.repositories.UserRepository;
import com.dharmaraj.restaurant_management_system.strategies.AggregatedRevenueCalculator;

public class RevenueServiceImpl implements RevenueService {
    UserRepository userRepository;
    DailyRevenueRepository dailyRevenueRepository;

    public RevenueServiceImpl(UserRepository userRepository, DailyRevenueRepository dailyRevenueRepository) {
        this.userRepository = userRepository;
        this.dailyRevenueRepository = dailyRevenueRepository;
    }

    @Override
    public AggregatedRevenue calculateRevenue(long userId, String queryType)
            throws UnauthorizedAccessException, UserNotFoundException, NoStrategyFound {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        User user = optionalUser.get();
        if (!user.getUserType().equals(UserType.BILLING)) {
            throw new UnauthorizedAccessException("User not authorize");
        }

        // check query type based on that write start date and end date
        RevenueQueryType qType = RevenueQueryType.valueOf(queryType);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        AggregatedRevenueCalculator aggregatedRevenueCalculator = QueryTypeFactory.getAggregatedRevenueCalculator(qType);
        DateRange dateRange = aggregatedRevenueCalculator.getDateRange(calendar);
        Date startDate = dateRange.getStartDate();
        Date endDate = dateRange.getEndDate();

        // query dailyrevenue repo for the revenue
        List<DailyRevenue> revenues = dailyRevenueRepository.getDailyRevenueBetweenDates(startDate, endDate);

        // sum all the revenue
        double totalGst = 0;
        double totalServiceCharge = 0;
        double revenueFromFoodSales = 0;

        for (DailyRevenue revenue : revenues) {
            totalGst += revenue.getTotalGst();
            totalServiceCharge += revenue.getTotalServiceCharge();
            revenueFromFoodSales += revenue.getRevenueFromFoodSales();
        }
        
        // set aggregate revenue
        AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
        aggregatedRevenue.setFromDate(startDate);
        aggregatedRevenue.setToDate(endDate);
        aggregatedRevenue.setRevenueFromFoodSales(revenueFromFoodSales);
        aggregatedRevenue.setTotalGst(totalGst);
        aggregatedRevenue.setTotalServiceCharge(totalServiceCharge);
        aggregatedRevenue.setTotalRevenue(totalGst + totalServiceCharge + revenueFromFoodSales);

        return aggregatedRevenue;
    }
}
