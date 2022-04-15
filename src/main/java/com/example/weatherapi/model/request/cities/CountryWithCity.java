package com.example.weatherapi.model.request.cities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryWithCity {

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("error")
	private boolean error;

}