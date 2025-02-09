package com.dharmaraj.restaurant_management_system.repositories;

import java.util.ArrayList;
import java.util.List;

import com.dharmaraj.restaurant_management_system.models.DietaryRequirement;
import com.dharmaraj.restaurant_management_system.models.MenuItem;

public class MenuRepositoryImpl implements MenuRepository {

    private List<MenuItem> menuItems;
    private int menuId;

    public MenuRepositoryImpl() {
        menuItems = new ArrayList<>();
        menuId = 0;
    }

    @Override
    public MenuItem add(MenuItem menuItem) {
        if (menuItem.getId() == 0) {
            menuItem.setId(++menuId);
        }
        menuItems.add(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItems;
    }

    @Override
    public List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement) {
        List<MenuItem> items = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getDietaryRequirement().equals(dietaryRequirement)) {
                items.add(menuItem);
            }
        }
        return items;
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        if (menuItem.getId() == 0) {
            menuItem.setId(++menuId);
        }
        for (MenuItem item : menuItems) {
            if (item.getId() == menuItem.getId()) {
                item.setName(menuItem.getName());
                item.setDescription(menuItem.getDescription());
                item.setDietaryRequirement(menuItem.getDietaryRequirement());
                item.setItemType(menuItem.getItemType());
                item.setPrice(menuItem.getPrice());
                return item;
            }
        }
        menuItems.add(menuItem);
        return menuItem;
    }

}

