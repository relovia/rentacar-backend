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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse add(@RequestBody @Valid CreateCarRequest request) {
        return carService.add(request);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/get/{id}")
    public GetCarByIdResponse getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @PutMapping("/update")
    public UpdateCarResponse update(@RequestBody UpdateCarRequest request) {
        return carService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}
