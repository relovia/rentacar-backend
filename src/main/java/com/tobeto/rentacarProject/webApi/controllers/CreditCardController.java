package com.tobeto.rentacarProject.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.tobeto.rentacarProject.business.abstracts.CreditCardService;
import com.tobeto.rentacarProject.business.dtos.requests.creditCard.CreateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.requests.creditCard.UpdateCreditCardRequest;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.CreateCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetAllCreditCardResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.GetCreditCardByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.creditCard.UpdateCreditCardResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/creditCards")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CreditCardController {
    private CreditCardService creditCardService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCreditCardResponse createCreditCard(@RequestBody @Valid CreateCreditCardRequest request) {
        return creditCardService.createCreditCard(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCreditCardResponse> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetCreditCardByIdResponse getCreditCardById(@PathVariable int id) {
        return creditCardService.getCreditCardById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateCreditCardResponse updateCreditCard(@RequestBody UpdateCreditCardRequest request) {
        return creditCardService.updateCreditCard(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCreditCard(@PathVariable int id) {
        creditCardService.deleteCreditCard(id);
    }

}
