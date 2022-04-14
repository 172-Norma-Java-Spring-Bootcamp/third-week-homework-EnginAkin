package com.example.weatherapi.service.concretes;

import com.example.weatherapi.service.abstracts.RestTemplateService;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplate restTemplate;


    @Override
    public ForecastWeatherApiRequest getForForecastApiDto(String url) {
        return restTemplate.getForEntity(url, ForecastWeatherApiRequest.class).getBody();
    }

    @Override
    public CurrentWeatherApiRequest getForCurrentApiDto(String url) {
        return restTemplate.getForEntity(url, CurrentWeatherApiRequest.class).getBody();
    }
}
