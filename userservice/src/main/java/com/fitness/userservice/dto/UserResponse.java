package com.fitness.userservice.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fitness.userservice.model.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({ "id", "email", "firstName", "lastName", "createdAt", "updatedAt" })
public class UserResponse {
    private String email;
    private String id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



}
