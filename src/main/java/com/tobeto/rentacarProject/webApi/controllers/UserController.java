package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.UserService;
import com.tobeto.rentacarProject.business.dtos.requests.user.CreateUserRequest;
import com.tobeto.rentacarProject.business.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacarProject.business.dtos.responses.user.CreateUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetAllUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetUserByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.UpdateUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllUserResponse> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserByIdResponse getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request) {
        return userService.updateUser(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
