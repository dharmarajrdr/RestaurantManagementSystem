package com.dharmaraj.restaurant_management_system.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill extends BaseModel {
    
    private double totalAmount;
    private double gst;
    private double serviceCharge;
}