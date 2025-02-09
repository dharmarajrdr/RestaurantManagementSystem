package com.dharmaraj.restaurant_management_system.custom_exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }
}
