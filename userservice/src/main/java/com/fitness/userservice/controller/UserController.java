package com.fitness.userservice.controller;

import com.fitness.userservice.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserProfile());
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register
            (@RequestBody RegisterUserRequest request){
        return ResponseEntity.ok(userService.regiter(request));
    }
}
