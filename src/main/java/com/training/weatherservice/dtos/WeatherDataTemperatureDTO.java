package com.training.weatherservice.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class WeatherDataTemperatureDTO {
    private long id;

    @JsonBackReference
    private WeatherDataDTO weatherDataDTO;

    private double temperature;
}
