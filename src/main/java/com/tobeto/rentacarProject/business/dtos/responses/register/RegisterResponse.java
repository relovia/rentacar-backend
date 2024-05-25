package com.tobeto.rentacarProject.business.dtos.responses.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String identityNumber;
    private String city;
    private String message;
    private LocalDateTime createdDate;
}
