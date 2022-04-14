package com.example.weatherapi.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
    private Object data;
    private String message;
    private Boolean isSuccessful;

    public GeneralResponse(Boolean isSuccessful){
        this.isSuccessful=isSuccessful;
    }
    public GeneralResponse(Boolean isSuccessful,String message){
        this.isSuccessful=isSuccessful;
        this.message=message;
    }
}
