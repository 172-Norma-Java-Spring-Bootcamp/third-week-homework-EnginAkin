package com.example.weatherapi.model.dto;

import com.example.weatherapi.model.request.Alerts;

import lombok.Data;

@Data
public class ForecastWeatherApiDto {

    private Alerts alerts;

    private CurrentDto current;

    private LocationDto location;

    private ForecastDto forecast;
}
