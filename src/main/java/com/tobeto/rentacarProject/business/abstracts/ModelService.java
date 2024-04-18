package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.model.CreateModelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.model.CreateModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    CreateModelResponse createModel(CreateModelRequest request);

    List<GetAllModelResponse> getAllModels();

    GetModelByIdResponse getModelById(int id);

    UpdateModelResponse updateModel(UpdateModelRequest request);

    void deleteModel(int id);
}
