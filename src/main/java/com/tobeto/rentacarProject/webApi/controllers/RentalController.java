package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.RentalService;
import com.tobeto.rentacarProject.business.dtos.requests.rental.CreateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.responses.rental.CreateRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetAllRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetRentalByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.UpdateRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {
    private RentalService rentalService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse createRental(@RequestBody @Valid CreateRentalRequest request) {
        return rentalService.createRental(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllRentalResponse> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetRentalByIdResponse getRentalById(@PathVariable int id) {
        return rentalService.getRentalById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateRentalResponse updateRental(@RequestBody UpdateRentalRequest request) {
        return rentalService.updateRental(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRental(@PathVariable int id) {
        rentalService.deleteRental(id);
    }
}