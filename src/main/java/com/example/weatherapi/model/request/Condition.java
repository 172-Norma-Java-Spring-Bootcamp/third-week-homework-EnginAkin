package com.example.weatherapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Condition{

	@JsonProperty("code")
	private int code;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("text")
	private String text;
}