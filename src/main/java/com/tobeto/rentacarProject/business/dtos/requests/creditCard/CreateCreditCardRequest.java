package com.tobeto.rentacarProject.business.dtos.requests.creditCard;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
    private String cardNumber;

    private String cardHolderName;

    @NotNull
    private int expiryMonth;

    @NotNull
    private int expiryYear;

    private String cvv;

    @NotNull
    private double balance;

    private Boolean isBlocked;
}
