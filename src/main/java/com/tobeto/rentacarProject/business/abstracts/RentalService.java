package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.rental.CreateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacarProject.business.dtos.responses.rental.CreateRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetAllRentalResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.GetRentalByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.rental.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    CreateRentalResponse createRental(CreateRentalRequest request);

    List<GetAllRentalResponse> getAllRentals();

    GetRentalByIdResponse getRentalById(int id);

    UpdateRentalResponse updateRental(UpdateRentalRequest request);

    void deleteRental(int id);

    void cancelRental(int id);
}
