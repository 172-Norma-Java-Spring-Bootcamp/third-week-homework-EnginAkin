package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.core.exceptions.*;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;

import java.util.List;

public interface WeatherApiService {

    CurrentWeatherDto getCurrentWeatherWithCityName(String cityName, String airQualityIndex) throws UnauthorizedException, CityNameCannotFoundException, AirQualityIndexNotFormatException, CityCannotFoundException;

    ForecastWeatherApiDto getForecastWeatherApiWithParameter(String cityName, String airQualityIndex, Integer days, String alert) throws CityNameCannotFoundException, UnauthorizedException, AirQualityIndexNotFormatException, AlertParameterNotFormatException, DayParameterInNotRangeException, CityCannotFoundException;
    Boolean getAllCity(String city) throws CityCannotFoundException;

}
