package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import com.example.weatherapi.model.request.cities.CountryWithCity;

import java.util.List;

public interface RestTemplateService {

    public ForecastWeatherApiRequest getForForecastApiRequest(String url);
    public CurrentWeatherApiRequest getForCurrentApiRequest(String url);
    public List<String> getAllCity(String url);
}
