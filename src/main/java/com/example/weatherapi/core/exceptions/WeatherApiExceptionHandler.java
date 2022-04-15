package com.example.weatherapi.core.exceptions;

import com.example.weatherapi.core.response.GeneralErrorResponse;
import com.example.weatherapi.core.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class WeatherApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public GeneralResponse handleUnauthorizedException(HttpClientErrorException exception){
        return new GeneralErrorResponse(exception.getMessage());

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleAiqException(AirQualityIndexFormatException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleAlertParameterException(AlertParameterFormatException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleValidationException(ConstraintViolationException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }








}
