package com.tobeto.rentacarProject.business.dtos.requests.rental;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    @Positive
    private int id;

    @NotNull
    private int carId;

    @FutureOrPresent
    private LocalDate rentStartDate;

    @FutureOrPresent
    private LocalDate rentEndDate;

    @Size(min = 2, max = 30)
    @NotNull
    private String renterName;

    @NotNull
    private Boolean isCancelled;
}
