package com.example.weatherapi.core.exceptions;

import com.example.weatherapi.core.response.GeneralErrorResponse;
import com.example.weatherapi.core.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleAiqException(AirQualityIndexNotFormatException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleAlertParameterException(AlertParameterNotFormatException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public GeneralResponse handleDayInNotParameterException(DayParameterInNotRangeException exception){
        return new GeneralErrorResponse(exception.getMessage());
    }





}
