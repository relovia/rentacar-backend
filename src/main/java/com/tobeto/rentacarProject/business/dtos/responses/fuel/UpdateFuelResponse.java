package com.tobeto.rentacarProject.business.dtos.responses.fuel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFuelResponse {
    private int id;
    private String name;
    private String message;
    private LocalDateTime createdDate;
}
