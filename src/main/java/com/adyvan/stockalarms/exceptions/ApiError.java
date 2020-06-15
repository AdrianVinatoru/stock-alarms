package com.adyvan.stockalarms.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {

    private String message;

    private HttpStatus httpStatus;

    private String error;

    public ApiError(HttpStatus status) {
        this.httpStatus = status;
    }

    public ApiError(HttpStatus httpStatus, String message, String error) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.error = error;
    }

}
