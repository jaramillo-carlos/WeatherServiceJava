package com.training.weatherservice.repositories;

import com.training.weatherservice.domain.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findById(Long id);
    List<WeatherData> findByDate(LocalDate date);
}
