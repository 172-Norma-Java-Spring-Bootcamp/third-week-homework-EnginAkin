package com.example.weatherapi.service.concretes;

import com.example.weatherapi.core.constant.uri.ErrorConstant;
import com.example.weatherapi.core.constant.uri.UriConstant;
import com.example.weatherapi.core.exceptions.AirQualityIndexNotFormatException;
import com.example.weatherapi.core.exceptions.AlertParameterNotFormatException;
import com.example.weatherapi.core.exceptions.CityCannotFoundException;
import com.example.weatherapi.core.exceptions.DayParameterInNotRangeException;
import com.example.weatherapi.core.utilities.mapper.ModelMapperService;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.service.abstracts.RestTemplateService;
import com.example.weatherapi.service.abstracts.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {

    private ModelMapperService modelMapperService;
    private RestTemplateService restTemplateService;

    @Autowired
    public WeatherApiServiceImpl(ModelMapperService modelMapperService,RestTemplateService restTemplateService){
        this.restTemplateService=restTemplateService;
        this.modelMapperService=modelMapperService;
    }





    //http://api.weatherapi.com/v1/current.json?key=b58e737a14604728a3b131306221104 &q=London&aqi=yes
    @Override
    public CurrentWeatherDto getCurrentWeatherWithCityName(String cityName, String airQualityIndex) throws AirQualityIndexNotFormatException, CityCannotFoundException {

        if(isValid(cityName)) throw new CityCannotFoundException(ErrorConstant.CITY_CANNOT_FOUND_ERROR);
        String url= UriConstant.CURRENT_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        // burada aiq için sadece yes yada no değerleri kabul edilebilir.
        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
        else if(!checkIfStrIsNo(airQualityIndex)) throw new AirQualityIndexNotFormatException(ErrorConstant.AIR_QUALITY_ERROR);
        return this.modelMapperService.forDto().map(restTemplateService.getForCurrentApiRequest(url),CurrentWeatherDto.class);

    }

    @Override
    public ForecastWeatherApiDto getForecastWeatherApiWithParameter(String cityName, String airQualityIndex, Integer days, String alert) throws AirQualityIndexNotFormatException, AlertParameterNotFormatException, DayParameterInNotRangeException, CityCannotFoundException {
        if(isValid(cityName)) throw new CityCannotFoundException(ErrorConstant.CITY_CANNOT_FOUND_ERROR);
        String url= UriConstant.FORECAST_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        System.out.println(" url 1: "+url);

        if(checkIfDayInRange(days)) throw new DayParameterInNotRangeException(ErrorConstant.DAY_PARAMETER_IN_NOT_RANGE);
        url+="&days="+days;
        System.out.println(" url 2: "+url);

        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
        else if(!checkIfStrIsNo(airQualityIndex)) throw new AirQualityIndexNotFormatException(ErrorConstant.AIR_QUALITY_ERROR);


        if(checkIfAlertsIsYes(alert)) url+="&alert=yes";
        else if(!checkIfStrIsNo(alert)) throw new AlertParameterNotFormatException(ErrorConstant.ALERT_ERROR);
        System.out.println(" url3: "+url);
        return this.modelMapperService.forDto().map(restTemplateService.getForForecastApiRequest(url),ForecastWeatherApiDto.class);

    }

    @Override
    public Boolean getAllCity(String city) throws CityCannotFoundException {
        if(!isValid(city)) throw new CityCannotFoundException(ErrorConstant.CITY_CANNOT_FOUND_ERROR);
        return restTemplateService.getAllCity(UriConstant.CITY_API_URI).contains(city);
    }


    private boolean isValid(String cityName) {
        cityName=cityName.toLowerCase();
        cityName=cityName.substring(0, 1).toUpperCase();
        return restTemplateService.getAllCity(UriConstant.CITY_API_URI).contains(cityName);
    }
    private boolean checkIfAiqIsYes(String aiq){
        return aiq.equals("yes");
    }
    private boolean checkIfDayInRange(int day){
        return day<0 || day>10;
    }
    private boolean checkIfStrIsNo(String aiq){
        return aiq.equals("no");
    }
    private boolean checkIfAlertsIsYes(String alert){
        return alert.equals("yes");
    }
}
