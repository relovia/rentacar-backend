package com.tobeto.rentacarProject.entities.concretes;

import com.tobeto.rentacarProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "rentStartDate")
    private LocalDate rentStartDate;

    @Column(name = "rentEndDate")
    private LocalDate rentEndDate;

    @Column(name = "renterName")
    private String renterName;

    @Column(name = "isCancelled")
    private boolean isCancelled = false;
}
