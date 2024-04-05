package com.tobeto.rentacarProject.dataAccess.abstracts;

import com.tobeto.rentacarProject.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByNameIgnoreCase(String name);
}
