package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.UserRepository;
import com.tobeto.rentacarProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    public void userNameCanNotBeDuplicated(String userName) {
        Optional<User> user = userRepository.findByUsernameIgnoreCase(userName);
        if (user.isPresent()) {
            throw new BusinessException("User name exists.");
        }
    }
}
