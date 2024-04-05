package com.tobeto.rentacarProject.business.dtos.responses.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTransmissionResponse {
    private int id;
    private String name;
}
