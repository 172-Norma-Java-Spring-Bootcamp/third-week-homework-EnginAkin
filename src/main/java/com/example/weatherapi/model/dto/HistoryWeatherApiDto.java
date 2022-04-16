package com.example.weatherapi.model.dto;

import lombok.Data;

@Data
public class HistoryWeatherApiDto {


    private LocationDto location;

    private ForecastDto forecast;
}
