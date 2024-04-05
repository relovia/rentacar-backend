package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentacarProject.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    ModelRepository modelRepository;

    public void modelNameCanNotBeDuplicated(String modelName) {
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);
        if (model.isPresent()) {
            throw new BusinessException("Model name exists.");
        }
    }
}
