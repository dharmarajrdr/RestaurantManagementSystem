package com.dharmaraj.restaurant_management_system.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyRevenue extends BaseModel {

    private double revenueFromFoodSales;
    private Date date;
    private double totalGst;
    private double totalServiceCharge;
}
