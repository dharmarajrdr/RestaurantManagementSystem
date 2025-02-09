package com.dharmaraj.restaurant_management_system.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DateRange {
    
    private Date startDate;
    private Date endDate;
}
