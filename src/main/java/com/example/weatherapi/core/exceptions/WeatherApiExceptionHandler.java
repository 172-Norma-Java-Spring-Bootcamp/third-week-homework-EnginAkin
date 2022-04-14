package com.example.weatherapi.core.exceptions;

import com.example.weatherapi.core.response.GeneralErrorResponse;
import com.example.weatherapi.core.response.GeneralResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class WeatherApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public GeneralResponse handleUnauthorizedException(HttpClientErrorException exception){
        if(exception.getStatusCode()==HttpStatus.BAD_REQUEST){
            return new GeneralErrorResponse("City name No matching location found");
        }
        return new GeneralErrorResponse("Api Key not valid");

    }





}
