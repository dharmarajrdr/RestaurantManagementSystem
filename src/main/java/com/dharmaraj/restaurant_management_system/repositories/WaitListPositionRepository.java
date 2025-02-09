package com.dharmaraj.restaurant_management_system.repositories;

import com.dharmaraj.restaurant_management_system.models.WaitListPosition;

import java.util.List;

public interface WaitListPositionRepository {

    WaitListPosition save(WaitListPosition waitListPosition);

    List<WaitListPosition> findAll();

    WaitListPosition delete(WaitListPosition waitListPosition);
}
