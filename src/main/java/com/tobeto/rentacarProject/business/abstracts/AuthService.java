package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.login.LoginRequest;
import com.tobeto.rentacarProject.business.dtos.requests.register.RegisterRequest;
import com.tobeto.rentacarProject.business.dtos.responses.login.LoginResponse;
import com.tobeto.rentacarProject.business.dtos.responses.register.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);
}
