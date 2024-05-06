package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.RentalRepository;
import com.tobeto.rentacarProject.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RentalBusinessRules {
    RentalRepository rentalRepository;

    public void rentalNameCanNotBeDuplicated(String renterName) {
        Optional<Rental> rental = rentalRepository.findByRenterNameIgnoreCase(renterName);
        if (rental.isPresent()) {
            throw new BusinessException("Rental name exists.");
        }
    }

    public void checkCarAvailability(int carId, LocalDate rentStartDate, LocalDate rentEndDate) {
        List<Rental> overlappingRentals = rentalRepository.findByCarIdAndRentEndDateAfterAndRentStartDateBefore(carId, rentStartDate, rentEndDate);

        if (!overlappingRentals.isEmpty()) {
            throw new BusinessException("Car is not available for rental during the specified period.");
        }
    }
}
