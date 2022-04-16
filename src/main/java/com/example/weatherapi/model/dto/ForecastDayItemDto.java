package com.example.weatherapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ForecastDayItemDto {

    private String date;

    private AstroWeatherInfoDto astro;

    private List<HourWeatherInfoDto> hour;

    private DayWeatherInfoDto day;
}
