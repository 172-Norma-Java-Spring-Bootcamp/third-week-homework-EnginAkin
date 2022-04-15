package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.Current;
import com.example.weatherapi.model.request.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrentWeatherDto {

    private CurrentDto current;

    private LocationDto location;


}
