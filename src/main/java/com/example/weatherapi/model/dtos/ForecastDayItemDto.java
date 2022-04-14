package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.AstroWeatherInfo;
import com.example.weatherapi.model.request.DayWeatherInfo;
import com.example.weatherapi.model.request.HourWeatherInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDayItemDto {

    private String date;

    private AstroWeatherInfoDto astro;

    private List<HourWeatherInfoDto> hour;

    private DayWeatherInfoDto day;
}
