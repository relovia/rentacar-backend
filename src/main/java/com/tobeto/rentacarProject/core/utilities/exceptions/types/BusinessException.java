package com.tobeto.rentacarProject.core.utilities.exceptions.types;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
