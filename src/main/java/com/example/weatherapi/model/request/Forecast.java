package com.example.weatherapi.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Forecast{

	@JsonProperty("forecastday")
	private List<ForecastdayItem> forecastday;
}