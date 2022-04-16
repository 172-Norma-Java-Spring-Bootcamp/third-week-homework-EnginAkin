package com.example.weatherapi.model.dto;

import lombok.Data;

@Data
public class HourWeatherInfoDto {

	private double tempC;
	private String time;
	private ConditionDto condition;

}