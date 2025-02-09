package com.dharmaraj.restaurant_management_system.custom_exception;

public class InvalidBillException extends Exception {
    public InvalidBillException(String message) {
        super(message);
    }
}