package com.dharmaraj.restaurant_management_system.dtos;

public class UpdateWaitListRequestDto {

    private long userId;
    private int numberOfSeats;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
