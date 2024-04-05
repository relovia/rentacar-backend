package com.tobeto.rentacarProject.business.dtos.requests.brand;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequest {
    @Positive
    private int id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
}
