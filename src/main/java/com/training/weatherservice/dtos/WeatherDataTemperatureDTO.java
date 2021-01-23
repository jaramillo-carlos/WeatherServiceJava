package com.training.weatherservice.dtos;

import lombok.Data;

@Data
public class WeatherDataTemperatureDTO {
    private long id;

    private WeatherDataDTO weatherDataDTO;

    private double temperature;
}
