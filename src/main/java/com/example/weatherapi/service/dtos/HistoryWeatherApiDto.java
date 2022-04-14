package com.example.weatherapi.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryWeatherApiDto {
//http://api.weatherapi.com/v1/history.json?key=b58e737a14604728a3b131306221104 &q=London&dt=2010-01-01

    private Location location;
    private ForecastWeather forecastWeather;
}
