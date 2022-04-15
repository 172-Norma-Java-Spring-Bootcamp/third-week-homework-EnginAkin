package com.example.weatherapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class HistoryWeatherApiRequest{

	@JsonProperty("location")
	private Location location;

	@JsonProperty("forecast")
	private Forecast forecast;
}