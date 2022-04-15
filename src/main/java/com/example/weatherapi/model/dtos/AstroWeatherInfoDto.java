package com.example.weatherapi.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AstroWeatherInfoDto {

    private String sunrise;

    private String sunset;

}
