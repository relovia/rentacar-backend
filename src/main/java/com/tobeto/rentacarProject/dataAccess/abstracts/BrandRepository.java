package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByNameIgnoreCase(String name);
}
