package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.core.exceptions.*;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.dtos.HistoryWeatherApiDto;
import org.springframework.web.client.HttpClientErrorException;

public interface WeatherApiService {

    CurrentWeatherDto getCurrentWeatherWithCityName(String cityName, String airQualityIndex) throws UnauthorizedException, AirQualityIndexFormatException;

    ForecastWeatherApiDto getForecastWeatherApiWithParameter(String cityName, String airQualityIndex, Integer days, String alert) throws UnauthorizedException, AirQualityIndexFormatException, AlertParameterFormatException;


    HistoryWeatherApiDto getHistoryWeatherApiWithDate(String city, String date) throws HttpClientErrorException;
}
