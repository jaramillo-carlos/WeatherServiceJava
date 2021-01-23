package com.training.weatherservice.controllers;

import com.training.weatherservice.dtos.Response;
import com.training.weatherservice.dtos.WeatherDataDTO;
import com.training.weatherservice.services.WeatherDataService;
import com.training.weatherservice.utilities.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherDataController {
    private final WeatherDataService weatherDataService;
    private final ResponseBuilder builder;

    @GetMapping
    public Response findAll() {
        return builder.success(weatherDataService.findAll());
    }

    @GetMapping("/{idWeather}")
    public Response findById(@PathVariable Long idWeather) {
        return builder.success(weatherDataService.findById(idWeather));
    }

    @RequestMapping(method = RequestMethod.GET, params = {"date"})
    public Response findByDate(@RequestParam(required = false) LocalDate date) {
        return builder.success(weatherDataService.findByDate(date));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveOrUpdate(@RequestBody WeatherDataDTO weatherData) {
        weatherDataService.saveOrUpdate(weatherData);
        return builder.success();
    }

    @DeleteMapping("/{idWeather}")
    public Response deleteById(@PathVariable Long idWeather) {
        weatherDataService.deleteById(idWeather);
        return builder.success();
    }

    @DeleteMapping
    public Response deleteAll() {
        weatherDataService.deleteAll();
        return builder.success();
    }
}
