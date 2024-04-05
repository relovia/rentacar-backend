package com.tobeto.rentacarProject.core.utilities.exceptions.types;

public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
