package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.user.CreateUserRequest;
import com.tobeto.rentacarProject.business.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacarProject.business.dtos.responses.user.CreateUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetAllUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetUserByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.UpdateUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    CreateUserResponse createUser(CreateUserRequest request);

    List<GetAllUserResponse> getAllUsers();

    GetUserByIdResponse getUserById(int id);

    UpdateUserResponse updateUser(UpdateUserRequest request);

    void deleteUser(int id);
}
