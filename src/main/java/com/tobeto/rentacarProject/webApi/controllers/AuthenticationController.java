package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.AuthService;
import com.tobeto.rentacarProject.business.dtos.requests.login.LoginRequest;
import com.tobeto.rentacarProject.business.dtos.requests.register.RegisterRequest;
import com.tobeto.rentacarProject.business.dtos.responses.login.LoginResponse;
import com.tobeto.rentacarProject.business.dtos.responses.register.RegisterResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://rentacar-backend-575927ecf713.herokuapp.com/"})
public class AuthenticationController {
    private AuthService authenticationService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody @Valid RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }
}
