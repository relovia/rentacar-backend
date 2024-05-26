package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.UserService;
import com.tobeto.rentacarProject.business.dtos.requests.user.CreateUserRequest;
import com.tobeto.rentacarProject.business.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacarProject.business.dtos.responses.user.CreateUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetAllUserResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.GetUserByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.user.UpdateUserResponse;
import com.tobeto.rentacarProject.business.rules.UserBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.UserRepository;
import com.tobeto.rentacarProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        userBusinessRules.emailCanNotBeDuplicated(request.getEmail());

        User user = mapperService.forRequest().map(request, User.class);
        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);

        CreateUserResponse response = mapperService.forResponse().map(user, CreateUserResponse.class);
        return response;
    }

    @Override
    public List<GetAllUserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream()
                .map(user -> mapperService.forResponse().map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

    @Override
    public GetUserByIdResponse getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not exists."));

        GetUserByIdResponse response = mapperService.forResponse().map(user, GetUserByIdResponse.class);
        response.setMessage("User successfully listed.");
        return response;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        int userId = request.getId();
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User id not found."));

        mapperService.forRequest().map(request, existingUser);
        userRepository.save(existingUser);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setMessage("User successfully updated");
        return response;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
