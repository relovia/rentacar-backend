package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByPlateIgnoreCase(String plate);
}
