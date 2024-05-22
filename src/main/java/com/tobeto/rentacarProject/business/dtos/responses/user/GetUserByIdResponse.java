package com.tobeto.rentacarProject.business.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String roles;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String identityNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String message;
    private LocalDateTime createdDate;
}
