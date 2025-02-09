package com.dharmaraj.restaurant_management_system.controllers;

import com.dharmaraj.restaurant_management_system.dtos.AddUserToWaitListRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.AddUserToWaitListResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.GetUserWaitListRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.GetUserWaitListResponseDto;
import com.dharmaraj.restaurant_management_system.dtos.ResponseStatus;
import com.dharmaraj.restaurant_management_system.dtos.UpdateWaitListRequestDto;
import com.dharmaraj.restaurant_management_system.dtos.UpdateWaitListResponseDto;
import com.dharmaraj.restaurant_management_system.services.WaitListService;

public class WaitListController {
    
    public WaitListService waitListService;

    public WaitListController(WaitListService waitListService) {
        this.waitListService = waitListService;
    }

    public AddUserToWaitListResponseDto addUserToWaitList(AddUserToWaitListRequestDto requestDto) {
        AddUserToWaitListResponseDto responseDto = new AddUserToWaitListResponseDto();
        try {
            int position = waitListService.addUserToWaitList(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public UpdateWaitListResponseDto updateWaitList(UpdateWaitListRequestDto requestDto) {
        UpdateWaitListResponseDto responseDto = new UpdateWaitListResponseDto();
        try {
            waitListService.updateWaitList(requestDto.getUserId(), requestDto.getNumberOfSeats());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public GetUserWaitListResponseDto getWaitListStatus(GetUserWaitListRequestDto requestDto){
        GetUserWaitListResponseDto responseDto = new GetUserWaitListResponseDto();
        try {
            int position = waitListService.getWaitListPosition(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

}
