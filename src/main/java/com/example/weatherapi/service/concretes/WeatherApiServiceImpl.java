package com.example.weatherapi.service.concretes;

import com.example.weatherapi.core.constant.uri.ErrorConstant;
import com.example.weatherapi.core.constant.uri.UriConstant;
import com.example.weatherapi.core.exceptions.AirQualityIndexNotFormatException;
import com.example.weatherapi.core.exceptions.AlertParameterNotFormatException;
import com.example.weatherapi.core.exceptions.DayParameterInNotRangeException;
import com.example.weatherapi.core.utilities.mapper.ModelMapperService;
import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.example.weatherapi.model.dtos.ForecastWeatherApiDto;
import com.example.weatherapi.model.request.CurrentWeatherApiRequest;
import com.example.weatherapi.model.request.ForecastWeatherApiRequest;
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
    public CurrentWeatherDto getCurrentWeatherWithCityName(String cityName, String airQualityIndex) throws AirQualityIndexNotFormatException {
        String url= UriConstant.CURRENT_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        // burada aiq için sadece yes yada no değerleri kabul edilebilir.
        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
        else if(!checkIfStrIsNo(airQualityIndex)) throw new AirQualityIndexNotFormatException(ErrorConstant.AIR_QUALITY_ERROR);
        return this.modelMapperService.forDto().map(restTemplateService.getForCurrentApiDto(url),CurrentWeatherDto.class);

    }

    @Override
    public ForecastWeatherApiDto getForecastWeatherApiWithParameter(String cityName, String airQualityIndex, Integer days, String alert) throws AirQualityIndexNotFormatException, AlertParameterNotFormatException, DayParameterInNotRangeException {
        String url= UriConstant.FORECAST_URI +"key="+UriConstant.API_KEY +"&q="+cityName;
        if(checkIfDayInRange(days)) throw new DayParameterInNotRangeException(ErrorConstant.DAY_PARAMETER_IN_NOT_RANGE);
        url+="&days="+days;

        System.out.println("aiq : "+airQualityIndex);
        if(checkIfAiqIsYes(airQualityIndex)) url+="&aqi=yes";
        else if(!checkIfStrIsNo(airQualityIndex)) throw new AirQualityIndexNotFormatException(ErrorConstant.AIR_QUALITY_ERROR);
        System.out.println("alert : "+alert);

        if(checkIfAlertsIsYes(alert)) url+="&alert=yes";
        else if(!checkIfStrIsNo(alert)) throw new AlertParameterNotFormatException(ErrorConstant.ALERT_ERROR);

        return this.modelMapperService.forDto().map(restTemplateService.getForForecastApiDto(url), ForecastWeatherApiDto.class);
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
