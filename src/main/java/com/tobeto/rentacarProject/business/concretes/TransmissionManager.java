package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.TransmissionService;
import com.tobeto.rentacarProject.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.CreateTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetAllTransmissionResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.GetTransmissionByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.transmission.UpdateTransmissionResponse;
import com.tobeto.rentacarProject.business.rules.TransmissionBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.TransmissionRepository;
import com.tobeto.rentacarProject.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService mapperService;
    private TransmissionBusinessRules transmissionBusinessRules;

    @Override
    public CreateTransmissionResponse createTransmission(CreateTransmissionRequest request) {
        transmissionBusinessRules.transmissionNameCanNotBeDuplicated(request.getName());

        Transmission transmission = mapperService.forRequest().map(request, Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        transmissionRepository.save(transmission);

        CreateTransmissionResponse response = mapperService.forResponse().map(transmission, CreateTransmissionResponse.class);
        return response;
    }

    @Override
    public List<GetAllTransmissionResponse> getAllTransmissions() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GetAllTransmissionResponse> transmissionResponses = transmissions.stream()
                .map(transmission -> mapperService.forResponse().map(transmission, GetAllTransmissionResponse.class))
                .collect(Collectors.toList());
        return transmissionResponses;
    }

    @Override
    public GetTransmissionByIdResponse getTransmissionById(int id) {
        Transmission transmission = transmissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transmission not exists."));

        GetTransmissionByIdResponse response = mapperService.forResponse().map(transmission, GetTransmissionByIdResponse.class);
        response.setMessage("Transmission successfully listed.");
        return response;
    }

    @Override
    public UpdateTransmissionResponse updateTransmission(UpdateTransmissionRequest request) {
        int transmissionId = request.getId();
        Transmission existingTransmission = transmissionRepository.findById(transmissionId)
                .orElseThrow(() -> new RuntimeException("Transmission id not found."));

        mapperService.forRequest().map(request, existingTransmission);
        transmissionRepository.save(existingTransmission);

        UpdateTransmissionResponse response = new UpdateTransmissionResponse();
        response.setMessage("Transmission successfully updated");
        return response;
    }

    @Override
    public void deleteTransmission(int id) {
        transmissionRepository.deleteById(id);
    }
}
