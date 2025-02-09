package com.dharmaraj.restaurant_management_system.dtos;

import java.util.List;

import com.dharmaraj.restaurant_management_system.models.MenuItem;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetMenuItemsResponseDto {
    
    private List<MenuItem> menuItems;
    private ResponseStatus responseStatus;
}
