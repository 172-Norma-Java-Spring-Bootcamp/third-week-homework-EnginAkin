package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.core.exceptions.*;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.dtos.HistoryWeatherApiDto;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import com.example.weatherapi.model.request.HistoryWeatherApiRequest;

import java.util.List;

public interface WeatherApiService {

    CurrentWeatherDto getCurrentWeatherWithCityName(String cityName, String airQualityIndex) throws UnauthorizedException, AirQualityIndexNotFormatException;

    ForecastWeatherApiDto getForecastWeatherApiWithParameter(String cityName, String airQualityIndex, Integer days, String alert) throws UnauthorizedException, AirQualityIndexNotFormatException, AlertParameterNotFormatException;


    HistoryWeatherApiDto getHistoryWeatherApiWithDate(String city, String date);
}
