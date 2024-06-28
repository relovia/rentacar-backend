package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.TransmissionService;
import com.tobeto.rentacarProject.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.CreateTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.UpdateTransmissionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transmissions")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://rentacar-backend-575927ecf713.herokuapp.com/"})
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTransmissionResponse createTransmission(@RequestBody @Valid CreateTransmissionRequest request) {
        return transmissionService.createTransmission(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionResponse> getAllTransmissions() {
        return transmissionService.getAllTransmissions();
    }


    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetTransmissionByIdResponse getTransmissionById(@PathVariable int id) {
        return transmissionService.getTransmissionById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateTransmissionResponse updateTransmission(@RequestBody UpdateTransmissionRequest request) {
        return transmissionService.updateTransmission(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTransmission(@PathVariable int id) {
        transmissionService.deleteTransmission(id);
    }
}
