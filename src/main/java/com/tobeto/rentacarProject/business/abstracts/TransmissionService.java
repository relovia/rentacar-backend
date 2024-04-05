package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.CreateTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.UpdateTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    CreateTransmissionResponse add(CreateTransmissionRequest request);

    List<GetAllTransmissionResponse> getAll();

    GetTransmissionByIdResponse getTransmissionById(int id);

    UpdateTransmissionResponse update(UpdateTransmissionRequest request);

    void delete(int id);
}
