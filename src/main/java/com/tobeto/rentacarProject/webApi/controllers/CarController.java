package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.CarService;
import com.tobeto.rentacarProject.business.dtos.requests.car.CreateCarRequest;
import com.tobeto.rentacarProject.business.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacarProject.business.dtos.responses.car.CreateCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetAllCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetCarByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse createCar(@RequestBody @Valid CreateCarRequest request) {
        return carService.createCar(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<GetAllCarResponse>> getAllCars() {
        List<GetAllCarResponse> cars = carService.getAllCars();
        return ResponseEntity.ok().body(cars);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetCarByIdResponse getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateCarResponse updateCar(@RequestBody UpdateCarRequest request) {
        return carService.updateCar(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}
