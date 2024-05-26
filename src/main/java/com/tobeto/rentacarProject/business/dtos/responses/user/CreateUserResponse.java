package com.tobeto.rentacarProject.business.dtos.responses.user;


import com.tobeto.rentacarProject.core.enums.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResponse {
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
    private LocalDateTime createdDate;
}
