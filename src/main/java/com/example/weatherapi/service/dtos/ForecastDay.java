package com.example.weatherapi.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDay {
    private String date;
    private long date_epoch;
    private DayWeatherInfo dayWeatherInfo;
    private Astro astro;
    private ArrayList<HourWeatherInfo> hourWeatherInfo;
}
