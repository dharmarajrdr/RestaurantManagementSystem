package com.dharmaraj.restaurant_management_system.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AggregatedRevenue {
    
    private double revenueFromFoodSales;
    private Date fromDate;
    private Date toDate;
    private double totalGst;
    private double totalServiceCharge;
    private double totalRevenue;
}
