package com.tobeto.rentacarProject.business.dtos.responses.user;

import com.tobeto.rentacarProject.core.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String identityNumber;
    private String companyName;
    private Role role;
    private String phoneNumber;
    private String city;
    private String message;
    private LocalDateTime createdDate;
}
