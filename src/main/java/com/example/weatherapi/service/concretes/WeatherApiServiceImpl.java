package com.example.weatherapi.service.concretes;

import com.example.weatherapi.core.constant.uri.UriConstant;
import com.example.weatherapi.core.response.GeneralResponse;
import com.example.weatherapi.core.response.GeneralSuccesfulResponse;
import com.example.weatherapi.core.utilities.mapper.ModelMapperService;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import com.example.weatherapi.service.dtos.CurrentWeatherApiDto;
import com.example.weatherapi.service.dtos.ForecastWeatherApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiServiceImpl implements WeatherApiService {

    private RestTemplate restTemplate;
    private ModelMapperService modelMapperService;

    @Autowired
    public WeatherApiServiceImpl(RestTemplate restTemplate, ModelMapperService modelMapperService){
        this.restTemplate=restTemplate;
        this.modelMapperService=modelMapperService;

    }


    //http://api.weatherapi.com/v1/current.json?key=b58e737a14604728a3b131306221104 &q=London&aqi=yes
    @Override
    public GeneralResponse getCurrentWeatherWithCityName(String cityName,String airQualityIndex) {
        String url= UriConstant.CURRENT_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
    return new GeneralSuccesfulResponse(restTemplate.getForEntity(url, CurrentWeatherApiDto.class).getBody(),"işlem başarılı");

    }

    @Override
    public GeneralResponse getForecastWeatherApiWithParameter(String cityName,String airQualityIndex, Integer days, String alert) {
        String url= UriConstant.FORECAST_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        if(days<0|| days>10 ) days=1;
        url+="&days="+days;
        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
        if(checkIfAlertsIsYes(alert)) url+="&alert=yes";

        ForecastWeatherApiDto forecastWeatherApi=restTemplate.getForEntity(url, ForecastWeatherApiDto.class).getBody();
        return new GeneralSuccesfulResponse(forecastWeatherApi,"işlem başarılı");
    }

    private boolean checkIfAiqIsYes(String aiq){
        return aiq.equals("yes");
    }
    private boolean checkIfAlertsIsYes(String alert){
        return alert.equals("yes");
    }
}
