package com.dharmaraj.restaurant_management_system.models;

import java.util.List;

public class Customer extends BaseModel{
    
    private String name;
    private int visitCount;
    private List<Bill> bills;
}