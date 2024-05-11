package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.CarRepository;
import com.tobeto.rentacarProject.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CarBusinessRules {
    CarRepository carRepository;

    public void carPlateCanNotBeDuplicated(String plate) {
        Optional<Car> car = carRepository.findByPlateIgnoreCase(plate);
        if (car.isPresent()) {
            throw new BusinessException("Plate exists.");
        }
    }
}
