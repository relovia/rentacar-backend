package com.tobeto.rentacarProject.business.dtos.requests.creditCard;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreditCardRequest {
    @Positive
    private int id;

    @NotEmpty
    private String cardNumber;

    @NotEmpty
    private String cardHolderName;

    @NotEmpty
    private int expiryMonth;

    @NotEmpty
    private int expiryYear;

    @NotEmpty
    private String cvv;

    @NotNull
    private double balance;

    @NotNull
    private Boolean isBlocked;
}