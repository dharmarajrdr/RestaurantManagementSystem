package com.dharmaraj.restaurant_management_system.dtos;

import com.dharmaraj.restaurant_management_system.models.MenuItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMenuItemResponseDto {
    
    private ResponseStatus status;
    private MenuItem menuItem;
}
