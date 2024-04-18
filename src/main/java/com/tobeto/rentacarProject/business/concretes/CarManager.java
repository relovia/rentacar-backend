package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.CarService;
import com.tobeto.rentacarProject.business.dtos.requests.car.CreateCarRequest;
import com.tobeto.rentacarProject.business.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacarProject.business.dtos.responses.car.CreateCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetAllCarResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.GetCarByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.car.UpdateCarResponse;
import com.tobeto.rentacarProject.business.rules.CarBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.CarRepository;
import com.tobeto.rentacarProject.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService mapperService;
    private CarBusinessRules carBusinessRules;

    @Override
    public CreateCarResponse createCar(CreateCarRequest request) {
        carBusinessRules.carPlateCanNotBeDuplicated(request.getPlate());

        Car car = mapperService.forRequest().map(request, Car.class);
        car.setCreatedDate(LocalDateTime.now());
        carRepository.save(car);

        CreateCarResponse response = mapperService.forResponse().map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public List<GetAllCarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponse> getAllCarResponses = cars.stream()
                .map(car -> mapperService.forResponse().map(car, GetAllCarResponse.class))
                .collect(Collectors.toList());
        return getAllCarResponses;
    }

    @Override
    public GetCarByIdResponse getCarById(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not exists."));

        GetCarByIdResponse response = mapperService.forResponse().map(car, GetCarByIdResponse.class);
        response.setMessage("Car successfully updated");
        return response;
    }

    @Override
    public UpdateCarResponse updateCar(UpdateCarRequest request) {
        int carId = request.getId();
        Car existingCar = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car id not found."));

        mapperService.forRequest().map(request, existingCar);
        carRepository.save(existingCar);

        UpdateCarResponse response = new UpdateCarResponse();
        response.setMessage("Car successfully updated");
        return response;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
