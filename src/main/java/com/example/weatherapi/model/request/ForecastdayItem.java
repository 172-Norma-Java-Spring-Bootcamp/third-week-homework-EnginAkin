package com.example.weatherapi.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastdayItem{
 // dinlen daha sonra forecast day olarak dizi döndermiyor.
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