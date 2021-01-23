package com.training.weatherservice.services;


import com.training.weatherservice.dtos.WeatherDataDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherDataService {
    List<WeatherDataDTO> findAll();
    WeatherDataDTO findById(Long id);
    WeatherDataDTO findByDate(LocalDate date);
    void saveOrUpdate(WeatherDataDTO weatherDataDTO);
    void deleteById(Long id);
    void deleteAll();
}
