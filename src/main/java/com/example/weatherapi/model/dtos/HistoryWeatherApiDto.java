package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.Forecast;
import com.example.weatherapi.model.request.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryWeatherApiDto {


    private LocationDto location;

    private ForecastDto forecast;
}
