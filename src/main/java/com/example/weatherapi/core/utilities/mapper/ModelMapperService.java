package com.example.weatherapi.core.utilities.mapper;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forDto();
    ModelMapper forRequest();

}
