package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.ForecastdayItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDto {
    private List<ForecastDayItemDto> forecastday;
}
