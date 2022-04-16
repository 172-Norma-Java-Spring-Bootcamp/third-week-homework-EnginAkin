package com.example.weatherapi.model.dto;

import lombok.Data;

@Data
public class CurrentWeatherDto {

    private CurrentDto current;

    private LocationDto location;


}
