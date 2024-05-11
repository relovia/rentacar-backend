package com.tobeto.rentacarProject.business.dtos.requests.car;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @Positive
    private int id;

    @NotNull
    private String plate;

    @NotNull
    private int state;

    @NotNull
    private double dailyPrice;

}
