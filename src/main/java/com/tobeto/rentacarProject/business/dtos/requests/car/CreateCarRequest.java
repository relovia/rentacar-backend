package com.tobeto.rentacarProject.business.dtos.requests.car;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @Min(2000)
    @Max(2024)
    private int modelYear;

    @NotNull
    private String plate;

    @NotNull
    private int state;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelId;
}
