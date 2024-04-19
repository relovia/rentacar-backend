package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.ModelService;
import com.tobeto.rentacarProject.business.dtos.requests.model.CreateModelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.model.CreateModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.UpdateModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse createModel(@RequestBody @Valid CreateModelRequest request) {
        return modelService.createModel(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponse> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/get/{id}")
    public GetModelByIdResponse getModelById(@PathVariable int id) {
        return modelService.getModelById(id);
    }

    @PutMapping("/update")
    public UpdateModelResponse updateModel(@RequestBody UpdateModelRequest request) {
        return modelService.updateModel(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModel(@PathVariable int id) {
        modelService.deleteModel(id);
    }
}
