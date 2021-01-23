package com.training.weatherservice.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class WeatherDataDTO {
  private long id;

  private LocalDate date;

  private LocationDTO location;

  @JsonManagedReference
  private List<WeatherDataTemperatureDTO> temperature;
}
