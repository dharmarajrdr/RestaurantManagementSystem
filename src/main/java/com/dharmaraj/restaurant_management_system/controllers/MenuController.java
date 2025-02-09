package com.dharmaraj.restaurant_management_system.controllers;

import java.util.List;

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
