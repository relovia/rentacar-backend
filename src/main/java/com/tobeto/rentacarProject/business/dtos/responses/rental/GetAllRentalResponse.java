package com.tobeto.rentacarProject.business.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalResponse {
    private int id;
    private int carId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private String renterName;
    private Boolean isCancelled;
    private LocalDateTime createdDate;
}