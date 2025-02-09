package com.dharmaraj.restaurant_management_system.custom_exception;

public class CustomerSessionNotFound extends Exception{

        public CustomerSessionNotFound(String message) {
            super(message);
        }
}
