package com.training.weatherservice.dtos;

import lombok.Data;

@Data
public class LocationDTO {
  private long id;

  private double lat;

  private double lon;

  private String city;

  private String state;
}
