package com.example.weatherapi.core.exceptions;

import lombok.NoArgsConstructor;

public class ValidationException extends GeneralException{
    public ValidationException(String exception) {
        super(exception);
    }


}
