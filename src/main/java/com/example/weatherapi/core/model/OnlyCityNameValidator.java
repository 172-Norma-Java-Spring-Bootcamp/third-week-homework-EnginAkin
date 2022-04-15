package com.example.weatherapi.core.model;

import com.example.weatherapi.core.constant.uri.UriConstant;
import com.example.weatherapi.service.abstracts.RestTemplateService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Data
public class OnlyCityNameValidator implements ConstraintValidator<OnlyCityName,String> {


    private final RestTemplateService restTemplateService;


    @Override
    public boolean isValid(String cityName, ConstraintValidatorContext context) {
        cityName=cityName.toLowerCase();
        cityName=cityName.substring(0, 1).toUpperCase();
        return restTemplateService.getAllCity(UriConstant.CITY_API_URI).contains(cityName);
    }
}



