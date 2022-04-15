package com.example.weatherapi.model.dtos;

import com.example.weatherapi.model.request.Condition;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HourWeatherInfoDto {

	private double tempC;
	private String time;
	private ConditionDto condition;

}