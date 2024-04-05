package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
    Optional<Fuel> findByNameIgnoreCase(String name);

}
