package com.example.weatherapi.controller;

import com.example.weatherapi.core.annotations.ExpectedDate;
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
    public GeneralResponse getCurrentWeatherApi(@PathVariable("cityName") @CheckCityName String cityName, @RequestParam(value = "aqi:[a-zA-Z]*$",defaultValue = "no",required = false) String airQualityIndex) throws UnauthorizedException, AirQualityIndexFormatException {
        return GeneralSuccesfulResponse.of()
                .data(weatherApiService.getCurrentWeatherWithCityName(cityName,airQualityIndex))
                .message("successfully").build();
    }

    @GetMapping(path = "/weather/forecast/{cityName}")
    public GeneralResponse getForecastWeatherApi(@PathVariable("cityName")  @CheckCityName String cityName // It checks whether the incoming city name variable CityAPi is also present.
                                                , @RequestParam(value = "days",required = false,defaultValue = "1") @Min(1) @Max(10) Integer day
                                                , @RequestParam(value = "aqi",required = false,defaultValue = "no") String airQualityIndex
                                                , @RequestParam(value = "alert",required = false,defaultValue = "no") String alert) throws UnauthorizedException, AirQualityIndexFormatException, AlertParameterFormatException {
        return GeneralSuccesfulResponse.of()
                .data(weatherApiService.getForecastWeatherApiWithParameter(cityName,airQualityIndex,day,alert))
                .message("successfully").build();
    }

    @GetMapping(path = "weather/history/{cityName}")
    public GeneralResponse getHistoryWeatherApi(@PathVariable("cityName") @CheckCityName String cityName
            , @RequestParam(value = "date") @CustomDateFormat @ExpectedDate String date){ // date format is yyyy-mm-dd and max 1 week before date access weather info
        return GeneralSuccesfulResponse.of()
                .data(weatherApiService.getHistoryWeatherApiWithDate(cityName,date))
                .message("successfully").build();

    }
}
