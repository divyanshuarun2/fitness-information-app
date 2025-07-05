package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterUserRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String id){
        UserResponse userProfile = userService.getUserProfile(id);
        return ResponseEntity.ok(userProfile);

    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register
            (@Valid @RequestBody RegisterUserRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
}
