package com.example.weatherapi.model.request;

import com.example.weatherapi.model.dtos.CurrentWeatherDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrentWeatherApiRequest {

	@JsonProperty("current")
	private Current current;

	@JsonProperty("location")
	private Location location;



}