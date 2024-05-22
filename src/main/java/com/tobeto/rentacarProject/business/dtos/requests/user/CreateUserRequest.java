package com.tobeto.rentacarProject.business.dtos.requests.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotEmpty(message = "First name is required")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    @NotEmpty(message = "Company name is required")
    @Size(min = 2, max = 30, message = "Company name must be between 2 and 30 characters")
    private String companyName;

    @NotEmpty(message = "Roles is required")
    private String roles;

    @NotEmpty(message = "Username is required")
    @Size(min = 6, max = 24, message = "Username must be between 6 and 24 characters")
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, max = 24, message = "Password must be between 6 and 24 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,24}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    private String email;

    @NotEmpty(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must be between 10 and 10 characters")
    private String phoneNumber;

    @NotBlank(message = "Identity number is required")
    @Size(min = 11, max = 11, message = "Identity number must be between 11 and 11 characters")
    private String identityNumber;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "State is required")
    private String state;

    @NotEmpty(message = "Country is required")
    private String country;

    @NotEmpty(message = "Zip code is required")
    private String zipCode;
}
