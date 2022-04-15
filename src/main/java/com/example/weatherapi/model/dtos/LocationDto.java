package com.example.weatherapi.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LocationDto {

    @JsonProperty("localtime")
    private String localtime;

    @JsonProperty("country")
    private String country;

    @JsonProperty("name")
    private String name;

    @JsonProperty("region")
    private String region;

    @JsonProperty("tz_id")
    private String tzId;

}
