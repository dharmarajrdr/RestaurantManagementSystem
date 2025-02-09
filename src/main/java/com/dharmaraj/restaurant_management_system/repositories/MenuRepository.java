package com.dharmaraj.restaurant_management_system.repositories;

import java.util.List;

import com.dharmaraj.restaurant_management_system.models.DietaryRequirement;
import com.dharmaraj.restaurant_management_system.models.MenuItem;

public interface MenuRepository {
    
    MenuItem add(MenuItem menuItem);
    List<MenuItem> getAll();
    List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement);
    MenuItem save(MenuItem menuItem);
}
