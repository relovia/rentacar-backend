package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.AuthService;
import com.tobeto.rentacarProject.business.dtos.requests.login.LoginRequest;
import com.tobeto.rentacarProject.business.dtos.requests.register.RegisterRequest;
import com.tobeto.rentacarProject.business.dtos.responses.login.LoginResponse;
import com.tobeto.rentacarProject.business.dtos.responses.register.RegisterResponse;
import com.tobeto.rentacarProject.business.rules.UserBusinessRules;
import com.tobeto.rentacarProject.core.enums.Role;
import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.UserRepository;
import com.tobeto.rentacarProject.entities.concretes.User;
import com.tobeto.rentacarProject.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private UserRepository userRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        userBusinessRules.emailCanNotBeDuplicated(registerRequest.getEmail());

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .identityNumber(registerRequest.getIdentityNumber())
                .companyName(registerRequest.getCompanyName())
                .role(Role.USER) // Default role is user
                .phoneNumber(registerRequest.getPhoneNumber())
                .city(registerRequest.getCity())
                .build();

        user.setCreatedDate(LocalDateTime.now());
        userRepository.save(user);

        RegisterResponse registerResponse = mapperService.forResponse().map(user, RegisterResponse.class);
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        userBusinessRules.checkUserExists(loginRequest.getEmail());
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (!passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
            throw new BusinessException("Invalid email or password");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            String jwt = null;

            if (authentication.isAuthenticated()) {
                jwt = jwtService.generateToken(loginRequest.getEmail());
            } else {
                throw new BusinessException("Invalid email or password");
            }

            LoginResponse loginResponse = LoginResponse.builder()
                    .id(userOptional.get().getId())
                    .firstName(userOptional.get().getFirstName())
                    .lastName(userOptional.get().getLastName())
                    .email(userOptional.get().getEmail())
                    .role(userOptional.get().getRole().name())
                    .token(jwt)
                    .build();
            return loginResponse;
        } catch (Exception e) {
            throw new BusinessException("Authentication failed." + e.getMessage());
        }
    }
}
