package com.dharmaraj.restaurant_management_system.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSession extends BaseModel{

    private User user;
    private CustomerSessionStatus customerSessionStatus;

    public boolean isActiveSession() {
        return this.customerSessionStatus.equals(CustomerSessionStatus.ACTIVE);
    }
}