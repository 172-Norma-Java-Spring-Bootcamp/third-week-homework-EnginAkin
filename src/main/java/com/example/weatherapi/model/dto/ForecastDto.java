package com.example.weatherapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ForecastDto {
    private List<ForecastDayItemDto> forecastday;
}
