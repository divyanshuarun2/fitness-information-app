package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
   @NotBlank
   @Email(message = "invalid email format")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min=6,message = "password must contains 6 characters")
    private String password;
    private String firstName;
    private String lastName;

}
