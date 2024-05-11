package com.tobeto.rentacarProject.business.dtos.responses.creditCard;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCreditCardResponse {
    private int id;
    private String cardNumber;
    private String cardHolderName;
    private int expiryMonth;
    private int expiryYear;
    private String cvv;
    private double balance;
    private Boolean isBlocked;
    private LocalDateTime createdDate;
}
