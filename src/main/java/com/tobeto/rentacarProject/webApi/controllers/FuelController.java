package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.FuelService;
import com.tobeto.rentacarProject.business.dtos.requests.fuel.CreateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.fuel.UpdateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.CreateFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetAllFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetFuelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.UpdateFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuels")
@AllArgsConstructor
public class FuelController {
    private FuelService fuelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateFuelResponse add(@RequestBody @Valid CreateFuelRequest request) {
        return fuelService.add(request);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelResponse> getAll() {
        return fuelService.getAll();
    }

    @GetMapping("/get/{id}")
    public GetFuelByIdResponse getFuelById(@PathVariable int id) {
        return fuelService.getFuelById(id);
    }

    @PutMapping("/update")
    public UpdateFuelResponse update(@RequestBody UpdateFuelRequest request) {
        return fuelService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        fuelService.delete(id);
    }
}
