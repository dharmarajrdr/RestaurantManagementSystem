package com.dharmaraj.restaurant_management_system.models;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill extends BaseModel {
    
    private double totalAmount;
    private double gst;
    private double serviceCharge;
    private Map<MenuItem, Integer> orderedItems;
}