package com.dharmaraj.restaurant_management_system.controllers;

import java.util.List;

import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.dtos.AddMenuItemRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.AddMenuItemResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.GetMenuItemsRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.GetMenuItemsResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.ResponseStatus;
import com.dharmaraj.restaurant_management_system.models.MenuItem;
import com.dharmaraj.restaurant_management_system.services.MenuService;

public class MenuController {
    
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public AddMenuItemResponseDto addMenuItem(AddMenuItemRequestDto requestDto) {
        AddMenuItemResponseDto addMenuItemResponseDto = new AddMenuItemResponseDto();
        try {
            long userId = requestDto.getUserId();
            String name = requestDto.getName();
            double price = requestDto.getPrice();
            String dietaryRequirement = requestDto.getDietaryRequirement();
            String itemType = requestDto.getItemType();
            String description = requestDto.getDescription();
            MenuItem menuItem = menuService.addMenuItem(userId, name, price, dietaryRequirement, itemType, description);
            addMenuItemResponseDto.setMenuItem(menuItem);
            addMenuItemResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException | UnauthorizedAccessException e) {
            addMenuItemResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return addMenuItemResponseDto;
    }

    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto) {
        GetMenuItemsResponseDto getMenuItemsResponseDto = new GetMenuItemsResponseDto();
        try {
            List<MenuItem> menuItems = this.menuService.getMenuItems(requestDto.getDietaryRequirement());
            getMenuItemsResponseDto.setMenuItems(menuItems);
            getMenuItemsResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (IllegalArgumentException e) {
            getMenuItemsResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return getMenuItemsResponseDto;
    }
}
