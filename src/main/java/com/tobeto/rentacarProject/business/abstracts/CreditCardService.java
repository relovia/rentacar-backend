package com.tobeto.rentacarProject.business.abstracts;


import java.util.List;

import com.tobeto.rentacarProject.business.dtos.requests.creditCard.CreateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.requests.creditCard.UpdateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.CreateCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetAllCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetCreditCardByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.UpdateCreditCardResponse;

public interface CreditCardService {
    CreateCreditCardResponse createCreditCard(CreateCreditCardRequest request);

    List<GetAllCreditCardResponse> getAllCreditCards();

    GetCreditCardByIdResponse getCreditCardById(int id);

    UpdateCreditCardResponse updateCreditCard(UpdateCreditCardRequest request);

    void deleteCreditCard(int id);
}
