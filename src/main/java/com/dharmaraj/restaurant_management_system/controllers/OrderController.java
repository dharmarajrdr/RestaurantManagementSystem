package com.dharmaraj.restaurant_management_system.controllers;

import com.dharmaraj.restaurant_management_system.custom_exception.CustomerSessionNotFound;
import com.dharmaraj.restaurant_management_system.dtos.GenerateBillRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.GenerateBillResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.ResponseStatus;
import com.dharmaraj.restaurant_management_system.models.Bill;
import com.dharmaraj.restaurant_management_system.services.OrderService;

public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public GenerateBillResponseDto generateBill(GenerateBillRequestDto requestDto) {

        GenerateBillResponseDto generateBillResponseDto = new GenerateBillResponseDto();
        try {
            long userId = requestDto.getUserId();
            Bill bill = this.orderService.generateBill(userId);
            generateBillResponseDto.setBill(bill);
            generateBillResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (CustomerSessionNotFound e) {
            generateBillResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return generateBillResponseDto;
    }

}
