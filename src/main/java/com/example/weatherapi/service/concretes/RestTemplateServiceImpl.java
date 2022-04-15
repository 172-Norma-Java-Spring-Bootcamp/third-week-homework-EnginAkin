package com.example.weatherapi.service.concretes;

import com.example.weatherapi.model.request.cities.CountryWithCity;
import com.example.weatherapi.model.request.cities.DataItem;
import com.example.weatherapi.service.abstracts.RestTemplateService;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestTemplateServiceImpl implements RestTemplateService {

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
    public List<String> getAllCity(String url) {
        List<String> cities=new ArrayList<>();
        for(DataItem data: restTemplate.getForEntity(url, CountryWithCity.class).getBody().getData()){
            cities.addAll(data.getCities());
        }
        return cities;
    }
}
