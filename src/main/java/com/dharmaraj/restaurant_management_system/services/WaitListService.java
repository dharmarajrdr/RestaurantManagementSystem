package com.dharmaraj.restaurant_management_system.services;

import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;

public interface WaitListService {

    int addUserToWaitList(long userId) throws UserNotFoundException;

    int getWaitListPosition(long userId) throws UserNotFoundException;

    void updateWaitList(long adminUserId, int numberOfSpots) throws UserNotFoundException, UnauthorizedAccessException;

}
