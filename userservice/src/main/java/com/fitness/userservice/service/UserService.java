package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterUserRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserResponse getUserProfile(String id) {
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return createResponseData(user);


    }

    public UserResponse register(@Valid RegisterUserRequest request) {
        User user= new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        //saving into databases
        User savedUser = userRepo.save(user);
        //creating response data
       return createResponseData(savedUser);

    }

    private UserResponse createResponseData(User savedUser) {
        UserResponse response = new UserResponse();
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setEmail(savedUser.getEmail());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        response.setId(savedUser.getId());
        return response;
    }

    public Boolean existbyUserId(String userId) {
        return userRepo.existsById(userId);
    }
}
