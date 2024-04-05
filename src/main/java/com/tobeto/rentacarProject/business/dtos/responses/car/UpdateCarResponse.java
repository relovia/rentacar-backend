package com.tobeto.rentacarProject.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int state;
    private double dailyPrice;
    private int modelId;
    private String message;
    private LocalDateTime createdDate;
}
