package com.tobeto.rentacarProject.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tobeto.rentacarProject.business.abstracts.CreditCardService;
import com.tobeto.rentacarProject.business.dtos.requests.creditCard.CreateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.requests.creditCard.UpdateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.CreateCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetAllCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetCreditCardByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.UpdateCreditCardResponse;
import com.tobeto.rentacarProject.business.rules.CreditCardBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.CreditCardRepository;
import com.tobeto.rentacarProject.entities.concretes.CreditCard;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreditCardManager implements CreditCardService {
    private CreditCardRepository creditCardRepository;
    private ModelMapperService mapperService;
    private CreditCardBusinessRules creditCardBusinessRules;

    @Override
    public CreateCreditCardResponse createCreditCard(CreateCreditCardRequest request) {
        creditCardBusinessRules.cardNumberCanNotBeDuplicated(request.getCardNumber());

        CreditCard creditCard = mapperService.forRequest().map(request, CreditCard.class);
        creditCard.setCreatedDate(LocalDateTime.now());
        creditCardRepository.save(creditCard);

        CreateCreditCardResponse response = mapperService.forResponse().map(creditCard, CreateCreditCardResponse.class);
        return response;
    }

    @Override
    public List<GetAllCreditCardResponse> getAllCreditCards() {
        List<CreditCard> creditCards = creditCardRepository.findAll();
        List<GetAllCreditCardResponse> getAllCreditCardResponses = creditCards.stream()
                    .map(creditCard -> mapperService.forResponse().map(creditCard, GetAllCreditCardResponse.class))
                    .collect(Collectors.toList());
        return getAllCreditCardResponses;
        
    }

    @Override
    public GetCreditCardByIdResponse getCreditCardById(int id) {
        CreditCard creditCard = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit card not exists."));
        
        GetCreditCardByIdResponse response = mapperService.forResponse().map(creditCard, GetCreditCardByIdResponse.class);
        response.setMessage("Credit card successfully listed.");
        return response;
    }

    @Override
    public UpdateCreditCardResponse updateCreditCard(UpdateCreditCardRequest request) {
        int creditCardId = request.getId();
        CreditCard existingCreditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new RuntimeException("Credit card id not found."));
        
        mapperService.forRequest().map(request, existingCreditCard);
        creditCardRepository.save(existingCreditCard);

        UpdateCreditCardResponse response = new UpdateCreditCardResponse();
        response.setMessage("Credit card successfully updated.");
        return response;
    }

    @Override
    public void deleteCreditCard(int id) {
        creditCardRepository.deleteById(id);
    }
}
