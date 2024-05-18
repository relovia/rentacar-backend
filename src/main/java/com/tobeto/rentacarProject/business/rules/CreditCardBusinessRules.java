package com.tobeto.rentacarProject.business.rules;

import com.tobeto.rentacarProject.core.utilities.exceptions.types.BusinessException;
import com.tobeto.rentacarProject.dataAccess.abstracts.CreditCardRepository;
import com.tobeto.rentacarProject.entities.concretes.Car;
import com.tobeto.rentacarProject.entities.concretes.CreditCard;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreditCardBusinessRules {
    CreditCardRepository creditCardRepository;

    public void cardNumberCanNotBeDuplicated(String cardNumber) {
        Optional<CreditCard> existingCard = creditCardRepository.findByCardNumberIgnoreCase(cardNumber);
        if (existingCard.isPresent()) {
            throw new BusinessException("Credit card with this number already exists.");
        }
    }

    public void validateCreditCardExpiration(String cardNumber) {
        Optional<CreditCard> creditCardExpiration = creditCardRepository.findByCardNumberIgnoreCase(cardNumber);

        if (creditCardExpiration.isPresent()) {
            CreditCard creditCard = creditCardExpiration.get();
            LocalDate currentDate = LocalDate.now();
            // To check the last hour of the last day
            LocalDate expirationDate = LocalDate.of(creditCard.getExpiryYear(), creditCard.getExpiryMonth(), 1)
                    .plusMonths(1)
                    .minusDays(1);

            if (currentDate.isAfter(expirationDate)) {
                throw new BusinessException("Credit card is expired.");
            }
        } else {
            throw new BusinessException("Credit card not found.");
        }
    }

    public void checkCreditCardBalance(String cardNumber, Car car) {
        Optional<CreditCard> checkBalance = creditCardRepository.findByCardNumberIgnoreCase(cardNumber);

        if (checkBalance.isPresent()) {
            CreditCard creditCard = checkBalance.get();
            if (creditCard.getBalance() < car.getDailyPrice()) {
                throw new BusinessException("Insufficient balance on the credit card.");
            }
        } else {
            throw new BusinessException("Credit card not found.");
        }
    }

    public void checkCreditCardBlockedStatus(String cardNumber) {
        Optional<CreditCard> checkStatus = creditCardRepository.findByCardNumberIgnoreCase(cardNumber);

        if (checkStatus.isPresent()) {
            CreditCard foundCard = checkStatus.get();
            if (foundCard.getIsBlocked()) {
                throw new BusinessException("Credit card is blocked. Cannot proceed with transaction.");
            }
        } else {
            throw new BusinessException("Credit card not found");
        }
    }

    public void checkCreditCardOwner(String cardNumber, String cardHolderName) {
        Optional<CreditCard> checkOwner = creditCardRepository.findByCardNumberIgnoreCase(cardNumber);

        if (checkOwner.isPresent()) {
            CreditCard foundCard = checkOwner.get();
            if (!foundCard.getCardHolderName().equalsIgnoreCase(cardHolderName)) {
                throw new BusinessException("Credit card owner is not the same as the one provided.");
            }
        } else {
            throw new BusinessException("Credit card not found");
        }
    }
}
