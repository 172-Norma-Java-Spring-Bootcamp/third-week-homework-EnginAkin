package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import com.example.weatherapi.model.request.HistoryWeatherApiRequest;

public interface WeatherApiService {

    public ForecastWeatherApiRequest getForForecastApiRequest(String url);
    public CurrentWeatherApiRequest getForCurrentApiRequest(String url);
    public HistoryWeatherApiRequest getHistoryWeatherApiRequest(String url);
}
