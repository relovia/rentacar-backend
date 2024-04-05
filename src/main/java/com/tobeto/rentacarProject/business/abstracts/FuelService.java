package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.fuel.CreateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.fuel.UpdateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.CreateFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetAllFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetFuelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.UpdateFuelResponse;

import java.util.List;

public interface FuelService {
    CreateFuelResponse add(CreateFuelRequest createFuelRequest);

    List<GetAllFuelResponse> getAll();

    GetFuelByIdResponse getFuelById(int id);

    UpdateFuelResponse update(UpdateFuelRequest request);

    void delete(int id);
}
