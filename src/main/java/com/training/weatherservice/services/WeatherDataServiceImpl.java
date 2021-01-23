package com.training.weatherservice.services;

import com.training.weatherservice.domain.WeatherData;
import com.training.weatherservice.dtos.WeatherDataDTO;
import com.training.weatherservice.exceptions.DuplicatedException;
import com.training.weatherservice.exceptions.NotFound;
import com.training.weatherservice.repositories.WeatherDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherDataServiceImpl implements WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;

    @Setter(onMethod_ = @Autowired)
    private ModelMapper mapper;

    @Override
    public List<WeatherDataDTO> findAll() {
        return weatherDataRepository.findAll()
                .stream()
                .filter(Objects::nonNull)
                .map(weatherData -> mapper.map(weatherData, WeatherDataDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public WeatherDataDTO findById(Long id) {
        return weatherDataRepository.findById(id)
                .map(weatherData -> mapper.map(weatherData, WeatherDataDTO.class))
                .orElseThrow(NotFound::new);
    }

    @Override
    public WeatherDataDTO findByDate(LocalDate date) {
        return weatherDataRepository.findByDate(date)
                .map(weatherData -> mapper.map(weatherData, WeatherDataDTO.class))
                .orElseThrow(NotFound::new);
    }

    @Override
    public void saveOrUpdate(WeatherDataDTO weatherDataDTO) {
        Optional<WeatherData> weatherData = weatherDataRepository.findById(weatherDataDTO.getId());

        if (weatherData.isPresent()) throw new DuplicatedException();

        weatherDataRepository.save(mapper.map(weatherDataDTO, WeatherData.class));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        weatherDataRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        weatherDataRepository.deleteAll();
    }
}
