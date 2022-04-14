package com.example.weatherapi.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastWeatherApiDto {


    // http://api.weatherapi.com/v1/forecast.json?key=680a23b02a3c4f4a9fc160121221104&q=London&days=2&aqi=yes&alerts=yes
    private Location location;
    private Current current;
    private ForecastWeather forecastWeather;
    private Alert alert;
}
