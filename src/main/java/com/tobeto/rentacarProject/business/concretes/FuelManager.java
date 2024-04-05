package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.FuelService;
import com.tobeto.rentacarProject.business.dtos.requests.fuel.CreateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.requests.fuel.UpdateFuelRequest;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.CreateFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetAllFuelResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.GetFuelByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.fuel.UpdateFuelResponse;
import com.tobeto.rentacarProject.business.rules.FuelBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.FuelRepository;
import com.tobeto.rentacarProject.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService mapperService;
    private FuelBusinessRules fuelBusinessRules;

    @Override
    public CreateFuelResponse add(CreateFuelRequest request) {
        fuelBusinessRules.fuelNameCanNotBeDuplicated(request.getName());

        Fuel fuel = mapperService.forRequest().map(request, Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        fuelRepository.save(fuel);

        CreateFuelResponse createFuelResponse = mapperService.forResponse().map(fuel, CreateFuelResponse.class);
        return createFuelResponse;
    }

    @Override
    public List<GetAllFuelResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetAllFuelResponse> getAllFuelResponses = fuels.stream()
                .map(fuel -> mapperService.forResponse().map(fuel, GetAllFuelResponse.class))
                .collect(Collectors.toList());
        return getAllFuelResponses;
    }

    @Override
    public GetFuelByIdResponse getFuelById(int id) {
        Fuel fuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fuel not exists."));

        GetFuelByIdResponse response = mapperService.forResponse().map(fuel, GetFuelByIdResponse.class);
        response.setMessage("Fuel successfully listed");
        return response;
    }

    @Override
    public UpdateFuelResponse update(UpdateFuelRequest request) {
        int fuelId = request.getId();
        Fuel existingFuel = fuelRepository.findById(fuelId)
                .orElseThrow(() -> new RuntimeException("Fuel id not found."));

        mapperService.forRequest().map(request, existingFuel);
        fuelRepository.save(existingFuel);

        UpdateFuelResponse response = new UpdateFuelResponse();
        response.setMessage("Fuel successfully updated");
        return response;
    }

    @Override
    public void delete(int id) {
        fuelRepository.deleteById(id);
    }
}
