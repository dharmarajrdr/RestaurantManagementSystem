package com.dharmaraj.restaurant_management_system.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dharmaraj.restaurant_management_system.custom_exception.UnauthorizedAccessException;
import com.dharmaraj.restaurant_management_system.custom_exception.UserNotFoundException;
import com.dharmaraj.restaurant_management_system.models.User;
import com.dharmaraj.restaurant_management_system.models.UserType;
import com.dharmaraj.restaurant_management_system.models.WaitListPosition;
import com.dharmaraj.restaurant_management_system.repositories.UserRepository;
import com.dharmaraj.restaurant_management_system.repositories.WaitListPositionRepository;

public class WaitListServiceImpl implements WaitListService {

    private UserRepository userRepository;
    private WaitListPositionRepository waitListPositionRepository;

    public WaitListServiceImpl(UserRepository userRepository, WaitListPositionRepository waitListPositionRepository) {
        this.userRepository = userRepository;
        this.waitListPositionRepository = waitListPositionRepository;
    }

    @Override
    public int addUserToWaitList(long userId) throws UserNotFoundException {

        // int position = getWaitListPosition(userId);
        // if (position == -1) {   // position not in list.
        //     WaitListPosition waitListPosition = new WaitListPosition();
        //     User user = this.userRepository.findById(userId).get();
        //     waitListPosition.setUser(user);
        //     waitListPosition.setInsertedAt(new Date());
        //     this.waitListPositionRepository.save(waitListPosition);
        //     position = getWaitListPosition(userId);
        // }
        // return position;
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }
        User user = optionalUser.get();

        List<WaitListPosition> waitListPositions = this.waitListPositionRepository.findAll();
        int N = waitListPositions.size();
        for (int i = 0; i < N; i++) {
            if (waitListPositions.get(i).getUser().getId() == userId) {
                return i + 1;   // 1 based index
            }
        }

        WaitListPosition waitListPosition = new WaitListPosition();
        waitListPosition.setUser(user);
        waitListPosition.setInsertedAt(new Date());
        this.waitListPositionRepository.save(waitListPosition);

        waitListPositions = this.waitListPositionRepository.findAll();
        return waitListPositions.size();
    }

    @Override
    public int getWaitListPosition(long userId) throws UserNotFoundException {

        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }

        List<WaitListPosition> waitListPositions = this.waitListPositionRepository.findAll();
        int N = waitListPositions.size();
        for (int i = 0; i < N; i++) {
            if (waitListPositions.get(i).getUser().getId() == userId) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public void updateWaitList(long adminUserId, int numberOfSpots)
            throws UserNotFoundException, UnauthorizedAccessException {

        Optional<User> optionalUser = this.userRepository.findById(adminUserId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }

        User user = optionalUser.get();

        // if (!user.isAdmin()) {
        //     throw new UnauthorizedAccessException("Access Denied.");
        // }

        if(user.getUserType() != UserType.ADMIN) {
            throw new UnauthorizedAccessException("Access Denied.");
        }

        List<WaitListPosition> waitListPositions = this.waitListPositionRepository.findAll();

        // while (numberOfSpots > 0 && !waitListPositions.isEmpty()) {
        //     WaitListPosition waitListPosition = waitListPositions.get(0);
        //     this.waitListPositionRepository.delete(waitListPosition);
        //     waitListPositions.remove(0);
        //     numberOfSpots--;
        // }
        numberOfSpots = Math.min(numberOfSpots, waitListPositions.size());
        for(int i = 0;i < numberOfSpots;i++) {
            waitListPositionRepository.delete(waitListPositions.get(i));
        }
    }

}
