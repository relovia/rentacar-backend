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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transmissions")
@AllArgsConstructor
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTransmissionResponse add(@RequestBody @Valid CreateTransmissionRequest request) {
        return transmissionService.add(request);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionResponse> getAll() {
        return transmissionService.getAll();
    }


    @GetMapping("/get/{id}")
    public GetTransmissionByIdResponse getTransmissionById(@PathVariable int id) {
        return transmissionService.getTransmissionById(id);
    }

    @PutMapping("/update")
    public UpdateTransmissionResponse update(@RequestBody UpdateTransmissionRequest request) {
        return transmissionService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        transmissionService.delete(id);
    }
}
