package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.FuelRepository;
import com.tobeto.rentacarProject.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelBusinessRules {
    FuelRepository fuelRepository;

    public void fuelNameCanNotBeDuplicated(String fuelName) {
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(fuelName);
        if (fuel.isPresent()) {
            throw new BusinessException("Fuel name exists.");
        }
    }
}
