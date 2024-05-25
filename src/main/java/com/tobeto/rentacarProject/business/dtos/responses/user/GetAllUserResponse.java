package com.tobeto.rentacarProject.business.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
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
    private String city;
}
