package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.Alerts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class ForecastWeatherApiDto {

    private Alerts alerts;

    private CurrentDto current;

    private LocationDto location;

    private ForecastDto forecast;
}
