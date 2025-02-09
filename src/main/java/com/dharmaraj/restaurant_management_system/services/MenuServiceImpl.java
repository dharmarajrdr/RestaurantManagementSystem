package com.dharmaraj.restaurant_management_system.services;

import java.util.List;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.models.DietaryRequirement;
import com.dharmaraj.restaurant_management_system.models.ItemType;
import com.dharmaraj.restaurant_management_system.models.MenuItem;
import com.dharmaraj.restaurant_management_system.models.User;
import com.dharmaraj.restaurant_management_system.repositories.MenuRepository;
import com.dharmaraj.restaurant_management_system.repositories.UserRepository;

public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;
    private UserRepository userRepository;

    public MenuServiceImpl(UserRepository userRepository, MenuRepository menuRepository) {
        this.userRepository = userRepository;
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

    @Override
    public MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType,
            String description) throws UserNotFoundException, UnauthorizedAccessException {

        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        User user = optionalUser.get();
        if (!user.isAdmin()) {
            throw new UnauthorizedAccessException("Permission denied");
        }

        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setPrice(price);
        menuItem.setDietaryRequirement(DietaryRequirement.valueOf(dietaryRequirement));
        menuItem.setItemType(ItemType.valueOf(itemType));
        menuItem.setDescription(description);
        menuRepository.add(menuItem);
        return menuItem;
    }

}
