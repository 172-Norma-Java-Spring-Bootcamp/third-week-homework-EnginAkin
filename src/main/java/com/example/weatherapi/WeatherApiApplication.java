package com.example.weatherapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherApiApplication {

    // weather stack : 8e972e97b8c42339a9ae41e85cceda68

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApplication.class, args);
        System.out.println("gelindi");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
