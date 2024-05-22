package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.user.CreateUserRequest;
import com.tobeto.rentacarProject.business.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacarProject.business.dtos.responses.user.CreateUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetAllUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetUserByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.UpdateUserResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest request);

    List<GetAllUserResponse> getAllUser();

    GetUserByIdResponse getUserById(int id);

    UpdateUserResponse updateUser(UpdateUserRequest request);

    void deleteUser(int id);
}
