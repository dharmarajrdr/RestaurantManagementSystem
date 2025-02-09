package com.dharmaraj.restaurant_management_system.services;

import java.util.List;

import com.dharmaraj.restaurant_management_system.models.DietaryRequirement;
import com.dharmaraj.restaurant_management_system.models.MenuItem;
import com.dharmaraj.restaurant_management_system.repositories.MenuRepository;

public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuItem> getMenuItems(String itemType) {

        if (itemType == null) {
            return this.menuRepository.getAll();
        }

        try {
            DietaryRequirement dietaryRequirement = DietaryRequirement.valueOf(itemType);
            return this.menuRepository.getByDietaryRequirement(dietaryRequirement);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid dietary preference");
        }
    }

}
