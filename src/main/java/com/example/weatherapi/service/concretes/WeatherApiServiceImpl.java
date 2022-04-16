package com.example.weatherapi.service.concretes;

import com.example.weatherapi.core.exceptions.AirQualityIndexFormatException;
import com.example.weatherapi.core.exceptions.AlertParameterFormatException;
import com.example.weatherapi.core.exceptions.UnauthorizedException;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.dtos.HistoryWeatherApiDto;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import com.example.weatherapi.model.request.HistoryWeatherApiRequest;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import com.example.weatherapi.service.abstracts.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class WeatherApiServiceImpl implements WeatherApiService {
    private final RestTemplate restTemplate;


    @Override
    public ForecastWeatherApiRequest getForForecastApiRequest(String url) {
        return restTemplate.getForEntity(url, ForecastWeatherApiRequest.class).getBody();
    }

    @Override
    public CurrentWeatherApiRequest getForCurrentApiRequest(String url) {
        return restTemplate.getForEntity(url, CurrentWeatherApiRequest.class).getBody();
    }



    @Override
    public HistoryWeatherApiRequest getHistoryWeatherApiRequest(String url) {
        return this.restTemplate.getForEntity(url,HistoryWeatherApiRequest.class).getBody();
    }


}
