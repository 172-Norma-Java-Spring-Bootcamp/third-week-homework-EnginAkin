package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;

public interface RestTemplateService {

    public ForecastWeatherApiRequest getForForecastApiDto(String url);
    public CurrentWeatherApiRequest getForCurrentApiDto(String url);
}
