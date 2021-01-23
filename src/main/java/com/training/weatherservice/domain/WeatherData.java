package com.training.weatherservice.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="weather_data")
public class WeatherData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @DateTimeFormat(pattern="yyyy-MM-dd")
  private LocalDate date;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private Location location;

  @OneToMany(mappedBy = "weatherData", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WeatherDataTemperature> temperature;
}
