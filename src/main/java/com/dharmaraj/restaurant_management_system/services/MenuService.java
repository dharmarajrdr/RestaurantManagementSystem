package com.dharmaraj.restaurant_management_system.services;

import java.util.List;

import com.dharmaraj.restaurant_management_system.models.MenuItem;

public interface MenuService {
    
    List<MenuItem> getMenuItems(String itemType);
}
