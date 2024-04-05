package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentacarProject.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    BrandRepository brandRepository;

        public void brandNameCanNotBeDuplicated(String brandName) {
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent()) {
            throw new BusinessException("Brand name exists.");
        }
    }
}
