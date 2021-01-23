package com.training.weatherservice.services;

import com.training.weatherservice.domain.WeatherData;
import com.training.weatherservice.dtos.WeatherDataDTO;
import com.training.weatherservice.exceptions.DuplicatedException;
import com.training.weatherservice.repositories.WeatherDataRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherDataServiceImplTest {

    @InjectMocks
    private WeatherDataServiceImpl service;

    @Mock
    private WeatherDataRepository repository;

    @Mock
    private ModelMapper mapper;

    @Before
    public void init() {
        service.setMapper(mapper);
    }

    @Test
    public void findAll() {
        WeatherData weatherData = mock(WeatherData.class);
        WeatherDataDTO weatherDataDTO = mock(WeatherDataDTO.class);
        List<WeatherData> list = Collections.singletonList(weatherData);

        when(repository.findAll()).thenReturn(list);
        when(mapper.map(weatherData, WeatherDataDTO.class)).thenReturn(weatherDataDTO);

        Assert.assertNotNull(service.findAll());
    }

    @Test
    public void findById() {
        Long id = 1L;
        WeatherData weatherData = mock(WeatherData.class);
        WeatherDataDTO weatherDataDTO = mock(WeatherDataDTO.class);


        Optional<WeatherData> optional = Optional.of(weatherData);

        when(repository.findById(id)).thenReturn(optional);
        when(mapper.map(weatherData, WeatherDataDTO.class)).thenReturn(weatherDataDTO);

        Assert.assertNotNull(service.findById(id));
    }

    @Test
    public void findByDate() {
        LocalDate date = LocalDate.now();
        WeatherData weatherData = mock(WeatherData.class);
        WeatherDataDTO weatherDataDTO = mock(WeatherDataDTO.class);

        List<WeatherData> list = Collections.singletonList(weatherData);

        when(repository.findByDate(date)).thenReturn(list);
        when(mapper.map(weatherData, WeatherDataDTO.class)).thenReturn(weatherDataDTO);

        Assert.assertNotNull(service.findByDate(date));
    }

    @Test(expected = DuplicatedException.class)
    public void saveOrUpdateWhenThrow() {
        WeatherDataDTO dto = mock(WeatherDataDTO.class);

        when(dto.getId()).thenReturn(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(new WeatherData()));

        service.saveOrUpdate(dto);
    }

    @Test
    public void saveOrUpdate() {
        Long id = 1L;
        WeatherDataDTO weatherDataDTO = mock(WeatherDataDTO.class);

        Optional<WeatherData> optional = Optional.empty();

        when(weatherDataDTO.getId()).thenReturn(id);
        when(repository.findById(id)).thenReturn(optional);


        service.saveOrUpdate(weatherDataDTO);
    }

    @Test
    public void deleteById() {
        Long id = 1L;
        WeatherData weatherData = mock(WeatherData.class);
        WeatherDataDTO weatherDataDTO = mock(WeatherDataDTO.class);
        WeatherDataServiceImpl spy = PowerMockito.spy(service);


        doReturn(weatherDataDTO).when(spy).findById(id);
        doNothing().when(repository).deleteById(id);
        when(mapper.map(weatherData, WeatherDataDTO.class)).thenReturn(weatherDataDTO);

        spy.deleteById(id);
    }

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteAll() {
        doNothing().when(repository).deleteAll();

        service.deleteAll();

        verify(repository, times(1));
    }
}