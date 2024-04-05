package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.model.CreateModelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.model.CreateModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    CreateModelResponse add(CreateModelRequest request);

    List<GetAllModelResponse> getAll();

    GetModelByIdResponse getModelById(int id);

    UpdateModelResponse update(UpdateModelRequest request);

    void delete(int id);
}
