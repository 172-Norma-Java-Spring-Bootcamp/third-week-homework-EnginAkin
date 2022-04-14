package com.example.weatherapi.controller;

import com.example.weatherapi.core.exceptions.*;
import com.example.weatherapi.core.response.GeneralResponse;
import com.example.weatherapi.core.response.GeneralSuccesfulResponse;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiService weatherApiService;
    // TODO day array olarak dönmüyor
    // TODO valid işlemlerini yap .

    @GetMapping(path = "/weather/current/{cityName}")
    public GeneralResponse getCurrentWeatherApiWithCityName(@PathVariable("cityName") String cityName, @RequestParam(value = "aqi",defaultValue = "no",required = false) String airQualityIndex) throws UnauthorizedException, CityNameCannotFoundException, AirQualityIndexNotFormatException {

        return  new GeneralSuccesfulResponse(weatherApiService.getCurrentWeatherWithCityName(cityName,airQualityIndex),"successfully");
    }

    //http://api.weatherapi.com/v1/forecast.json?key=680a23b02a3c4f4a9fc160121221104 &q=London&days=1&aqi=yes&alerts=yes
    @GetMapping(path = "/weather/forecast/{cityName}")
    public GeneralResponse getForecastWeatherApi(@PathVariable("cityName") String cityName,
                                                  @RequestParam(value = "days",required = false,defaultValue = "1") Integer days
                                                ,@RequestParam(value = "aqi",required = false,defaultValue = "no") String airQualityIndex,
                                                 @RequestParam(value = "alert",required = false,defaultValue = "no") String alert) throws UnauthorizedException, CityNameCannotFoundException, AirQualityIndexNotFormatException, AlertParameterNotFormatException, DayParameterInNotRangeException {
        return new GeneralSuccesfulResponse(weatherApiService.getForecastWeatherApiWithParameter(cityName,airQualityIndex,days,alert),"successfully");
    }
}
