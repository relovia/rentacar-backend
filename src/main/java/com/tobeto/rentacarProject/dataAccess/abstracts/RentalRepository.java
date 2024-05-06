package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Optional<Rental> findByRenterNameIgnoreCase(String renterName);
    List<Rental> findByCarIdAndRentEndDateAfterAndRentStartDateBefore(Integer carId, LocalDate rentStartDate, LocalDate rentEndDate);
}
