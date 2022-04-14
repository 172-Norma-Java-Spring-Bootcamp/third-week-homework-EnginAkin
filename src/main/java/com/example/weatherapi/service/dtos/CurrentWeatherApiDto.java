package com.example.weatherapi.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherApiDto {

    //http://api.weatherapi.com/v1/current.json?key=b58e737a14604728a3b131306221104 &q=London&aqi=yes

    private Location location;
    private Current current;
}
