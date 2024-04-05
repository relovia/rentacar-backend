package com.tobeto.rentacarProject.entities.concretes;

import com.tobeto.rentacarProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "state")
    private int state;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;
}
