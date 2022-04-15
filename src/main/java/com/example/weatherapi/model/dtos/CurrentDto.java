package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.AirQuality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrentDto {
    private double feelslikeC;

    private double uv;

    private String lastUpdated;

    private double feelslikeF;

    private AirQuality airQuality;

    private double tempC;

    private int cloud;

    private ConditionDto condition;

    private double windMph;

}
