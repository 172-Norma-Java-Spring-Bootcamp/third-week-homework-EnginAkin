package com.example.weatherapi.controller;

import com.example.weatherapi.core.exceptions.CityNameCannotFoundException;
import com.example.weatherapi.core.exceptions.UnauthorizedException;
import com.example.weatherapi.core.response.GeneralErrorResponse;
import com.example.weatherapi.core.response.GeneralResponse;
import com.example.weatherapi.core.response.GeneralSuccesfulResponse;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import com.example.weatherapi.service.concretes.WeatherApiServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiService weatherApiService;

    @GetMapping(path = "/weather/current/{cityName}")
    public GeneralResponse getCurrentWeatherApiWithCityName(@PathVariable("cityName") String cityName, @RequestParam(value = "aqi") String airQualityIndex) throws UnauthorizedException, CityNameCannotFoundException {
        return  weatherApiService.getCurrentWeatherWithCityName(cityName,airQualityIndex);
    }

    //http://api.weatherapi.com/v1/forecast.json?key=680a23b02a3c4f4a9fc160121221104 &q=London&days=1&aqi=yes&alerts=yes
    @GetMapping(path = "/weather/forecast/{cityName}")
    public GeneralResponse getForecastWeatherApi(@PathVariable("cityName") String cityName,
                                                 @RequestParam(value = "days",required = false,defaultValue = "1") Integer days
                                                ,@RequestParam(value = "aqi",required = false) String airQualityIndex,
                                                 @RequestParam(value = "alerts",required = false) String alert) throws UnauthorizedException, CityNameCannotFoundException {

// servici ayır
        //
return weatherApiService.getForecastWeatherApiWithParameter(cityName,airQualityIndex,days,alert);
    }
}
