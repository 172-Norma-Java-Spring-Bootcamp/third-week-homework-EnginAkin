package com.example.weatherapi.service.concretes;

import com.example.weatherapi.model.request.cities.CountryWithCity;
import com.example.weatherapi.model.request.cities.DataItem;
import com.example.weatherapi.service.abstracts.CountrySnowApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountrySnowApiServiceImpl implements CountrySnowApiService {

    private RestTemplate restTemplate;

    @Autowired
    public CountrySnowApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
