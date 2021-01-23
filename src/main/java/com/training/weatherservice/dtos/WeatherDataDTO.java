package com.training.weatherservice.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WeatherDataDTO {
  private long id;

  private LocalDate date;

  private LocationDTO location;

  private List<Double> temperature;
}
