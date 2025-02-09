package com.dharmaraj.restaurant_management_system.services;

import java.util.List;

import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.models.MenuItem;

public interface MenuService {
    
    List<MenuItem> getMenuItems(String itemType);

    MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType, String description) throws UserNotFoundException, UnauthorizedAccessException;
}
