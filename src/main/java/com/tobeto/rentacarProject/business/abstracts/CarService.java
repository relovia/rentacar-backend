package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.car.CreateCarRequest;
import com.tobeto.rentacarProject.business.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacarProject.business.dtos.responses.car.CreateCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetAllCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetCarByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.UpdateCarResponse;

import java.util.List;

public interface CarService {
    CreateCarResponse createCar(CreateCarRequest createCarRequest);

    List<GetAllCarResponse> getAllCars();

    GetCarByIdResponse getCarById(int id);

    UpdateCarResponse updateCar(UpdateCarRequest request);

    void deleteCar(int id);
}
