package com.tobeto.rentacarProject.business.dtos.requests.creditCard;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
    @NotNull
    private String cardNumber;

    @NotNull
    private String cardHolderName;

    @NotNull
    private int expiryMonth;

    @NotNull
    private int expiryYear;

    @NotNull
    private String cvv;

    @NotNull
    private double balance;

    @NotNull
    private Boolean isBlocked;
}
