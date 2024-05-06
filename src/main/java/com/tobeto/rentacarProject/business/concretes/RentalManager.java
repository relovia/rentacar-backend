package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.RentalService;
import com.tobeto.rentacarProject.business.dtos.requests.rental.CreateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.responses.rental.CreateRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetAllRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetRentalByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.UpdateRentalResponse;
import com.tobeto.rentacarProject.business.rules.RentalBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.RentalRepository;
import com.tobeto.rentacarProject.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService mapperService;
    private RentalBusinessRules rentalBusinessRules;

    @Override
    public CreateRentalResponse createRental(CreateRentalRequest request) {
        rentalBusinessRules.rentalNameCanNotBeDuplicated(request.getRenterName());
        rentalBusinessRules.checkCarAvailability(request.getCarId(), request.getRentStartDate(), request.getRentEndDate());

        Rental rental = mapperService.forRequest().map(request, Rental.class);
        rental.setCreatedDate(LocalDateTime.now());
        rentalRepository.save(rental);

        CreateRentalResponse response = mapperService.forResponse().map(rental, CreateRentalResponse.class);
        return response;
    }

    @Override
    public List<GetAllRentalResponse> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalResponse> response = rentals.stream()
                .map(rental -> mapperService.forResponse().map(rental, GetAllRentalResponse.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public GetRentalByIdResponse getRentalById(int id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not exists."));

        GetRentalByIdResponse response = mapperService.forResponse().map(rental, GetRentalByIdResponse.class);
        response.setMessage("Rental successfully listed.");
        return response;
    }

    @Override
    public UpdateRentalResponse updateRental(UpdateRentalRequest request) {
        int rentalId = request.getId();
        Rental existingRental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental id not found"));

        mapperService.forRequest().map(request, existingRental);
        rentalRepository.save(existingRental);

        UpdateRentalResponse response = new UpdateRentalResponse();
        response.setMessage("Rental successfully updated.");
        return response;
    }

    @Override
    public void deleteRental(int id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public void cancelRental(int id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not exists."));

        rental.setCancelled(true);
        rentalRepository.save(rental);
    }
}
