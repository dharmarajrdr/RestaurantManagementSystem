package com.dharmaraj.restaurant_management_system.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaitListPosition extends BaseModel {
    
    private User user;
    private Date insertedAt;
}
