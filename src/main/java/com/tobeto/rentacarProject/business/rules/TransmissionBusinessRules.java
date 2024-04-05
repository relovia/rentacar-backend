package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.TransmissionRepository;
import com.tobeto.rentacarProject.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
    TransmissionRepository transmissionRepository;

    public void transmissionNameCanNotBeDuplicated(String transmissionName) {
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName);
        if (transmission.isPresent()) {
            throw new BusinessException("Transmission name exists.");
        }
    }
}
