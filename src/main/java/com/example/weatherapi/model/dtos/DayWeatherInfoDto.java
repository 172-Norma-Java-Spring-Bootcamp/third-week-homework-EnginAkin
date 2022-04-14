package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.Condition;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayWeatherInfoDto {

	private double avgvisKm;

	private double avgtempC;

	private int dailyChanceOfSnow;

	private double maxtempC;

	private double mintempC;

	private ConditionDto condition;

	private double maxwindMph;

	private int dailyChanceOfRain;

}