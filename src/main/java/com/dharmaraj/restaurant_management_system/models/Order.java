package com.dharmaraj.restaurant_management_system.models;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends BaseModel{

    private CustomerSession customerSession;
    private Map<MenuItem, Integer> orderedItems;
}