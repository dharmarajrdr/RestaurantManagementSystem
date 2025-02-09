package com.dharmaraj.restaurant_management_system.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateWaitListRequestDto {

    private long userId;
    private int numberOfSeats;
}
