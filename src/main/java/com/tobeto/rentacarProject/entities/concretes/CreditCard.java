package com.tobeto.rentacarProject.entities.concretes;

import com.tobeto.rentacarProject.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntity {
    @Column(name = "cardNumber", unique = true)
    @NotNull
    @Pattern(regexp = "^[0-9]{16}$", message = "Invalid card number")
    private String cardNumber;

    @Column(name = "cardHolderName")
    @NotNull(message = "Card holder name cannot be null")
    private String cardHolderName;

    @Column(name = "expiryMonth")
    private int expiryMonth;

    @Column(name = "expiryYear")
    private int expiryYear;

    @Column(name = "cvv")
    @NotNull(message = "CVV cannot be null")
    @Pattern(regexp = "^[0-9]{3}$", message = "Invalid CVV")
    private String cvv;

    @Column(name = "balance")
    private double balance;

    @Column(name = "isBlocked")
    private Boolean isBlocked = false;
}
