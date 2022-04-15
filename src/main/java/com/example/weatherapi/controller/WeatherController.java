package com.example.weatherapi.controller;

import com.example.weatherapi.core.exceptions.*;
import com.example.weatherapi.core.annotations.CheckCityName;
import com.example.weatherapi.core.annotations.CustomDateFormat;
import com.example.weatherapi.core.response.GeneralResponse;
import com.example.weatherapi.core.response.GeneralSuccesfulResponse;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
@Validated
public class WeatherController {

    private final WeatherApiService weatherApiService;

    @GetMapping(path = "/weather/current/{cityName}")
    public GeneralResponse getCurrentWeatherApi(@PathVariable("cityName") @CheckCityName String cityName, @RequestParam(value = "aqi:[a-zA-Z]*$",defaultValue = "no",required = false) String airQualityIndex) throws UnauthorizedException, AirQualityIndexNotFormatException {
        return  new GeneralSuccesfulResponse(weatherApiService.getCurrentWeatherWithCityName(cityName,airQualityIndex),"successfully");
    }
    @GetMapping(path = "/weather/forecast/{cityName}")
    public GeneralResponse getForecastWeatherApi(@PathVariable("cityName")  @CheckCityName String cityName // It checks whether the incoming city name variable CityAPi is also present.
                                                , @RequestParam(value = "days",required = false,defaultValue = "1") @Min(1) @Max(10) Integer days
                                                , @RequestParam(value = "aqi",required = false,defaultValue = "no") String airQualityIndex
                                                , @RequestParam(value = "alert",required = false,defaultValue = "no") String alert) throws UnauthorizedException, AirQualityIndexNotFormatException, AlertParameterNotFormatException {
        return new GeneralSuccesfulResponse(weatherApiService.getForecastWeatherApiWithParameter(cityName,airQualityIndex,days,alert),"successfully");
    }


    @GetMapping(path = "weather/history/{city}")
    public GeneralResponse getHistoryWeatherApi(@PathVariable("city") @CheckCityName String city, @RequestParam(value = "date") @CustomDateFormat String date){

        return new GeneralSuccesfulResponse(weatherApiService.getHistoryWeatherApiWithDate(city,date),"successfully");
    }




}
