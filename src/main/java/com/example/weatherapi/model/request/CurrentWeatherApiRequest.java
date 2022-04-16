package com.example.weatherapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentWeatherApiRequest {

	@JsonProperty("current")
	private Current current;

	@JsonProperty("location")
	private Location location;



}