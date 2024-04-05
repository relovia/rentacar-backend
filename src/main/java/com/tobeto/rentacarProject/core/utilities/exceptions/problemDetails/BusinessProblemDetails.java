package com.tobeto.rentacarProject.core.utilities.exceptions.problemDetails;

import org.hibernate.dialect.function.array.H2ArrayContainsFunction;
import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setTitle("Business rule violation");
        setType("https://youtube.com");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
