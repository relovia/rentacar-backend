package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    Optional<Transmission> findByNameIgnoreCase(String name);
}
