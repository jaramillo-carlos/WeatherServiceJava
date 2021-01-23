package com.training.weatherservice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="weather_data_temperatures")
public class WeatherDataTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private WeatherData weatherData;

    private double temperature;

}
