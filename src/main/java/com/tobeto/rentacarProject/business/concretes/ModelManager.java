package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.ModelService;
import com.tobeto.rentacarProject.business.dtos.requests.model.CreateModelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.model.CreateModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetAllModelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.GetModelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.model.UpdateModelResponse;
import com.tobeto.rentacarProject.business.rules.ModelBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.ModelRepository;
import com.tobeto.rentacarProject.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService mapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public CreateModelResponse createModel(CreateModelRequest request) {
        modelBusinessRules.modelNameCanNotBeDuplicated(request.getName());

        Model model = mapperService.forRequest().map(request, Model.class);
        model.setCreatedDate(LocalDateTime.now());
        modelRepository.save(model);

        CreateModelResponse response = mapperService.forResponse().map(model, CreateModelResponse.class);
        return response;
    }

    @Override
    public List<GetAllModelResponse> getAllModels() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> getAllModelResponses = models.stream()
                .map(model -> mapperService.forResponse().map(model, GetAllModelResponse.class))
                .collect(Collectors.toList());
        return getAllModelResponses;
    }

    @Override
    public GetModelByIdResponse getModelById(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not exists."));

        GetModelByIdResponse response = mapperService.forResponse().map(model, GetModelByIdResponse.class);
        response.setMessage("Model successfully listed.");
        return response;
    }

    @Override
    public UpdateModelResponse updateModel(UpdateModelRequest request) {
        int modelId = request.getId();
        Model existingModel = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model id not found."));

        mapperService.forRequest().map(request, existingModel);
        modelRepository.save(existingModel);

        UpdateModelResponse response = new UpdateModelResponse();
        response.setMessage("Model successfully updated");
        return response;
    }

    @Override
    public void deleteModel(int id) {
        modelRepository.deleteById(id);
    }
}
