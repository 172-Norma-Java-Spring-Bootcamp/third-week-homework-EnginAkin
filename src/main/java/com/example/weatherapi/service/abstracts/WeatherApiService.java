package com.example.weatherapi.service.abstracts;

import com.example.weatherapi.core.exceptions.CityNameCannotFoundException;
import com.example.weatherapi.core.exceptions.UnauthorizedException;
import com.example.weatherapi.core.response.GeneralResponse;

public interface WeatherApiService {

    GeneralResponse getCurrentWeatherWithCityName(String cityName,String airQualityIndex) throws UnauthorizedException, CityNameCannotFoundException;

    GeneralResponse getForecastWeatherApiWithParameter(String cityName,String airQualityIndex,Integer days,String alert)throws CityNameCannotFoundException,UnauthorizedException;

}
