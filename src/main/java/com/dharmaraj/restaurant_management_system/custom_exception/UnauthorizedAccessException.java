package com.dharmaraj.restaurant_management_system.custom_exception;

public class UnauthorizedAccessException extends Exception{

        public UnauthorizedAccessException(String message) {
            super(message);
        }
}
