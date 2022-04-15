package com.example.weatherapi.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ForecastdayItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("astro")
	private AstroWeatherInfo astro;

	@JsonProperty("date_epoch")
	private int dateEpoch;

	@JsonProperty("hour")
	private List<HourWeatherInfo> hour;

	@JsonProperty("day")
	private DayWeatherInfo day;
}