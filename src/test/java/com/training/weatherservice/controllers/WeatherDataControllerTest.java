package com.training.weatherservice.controllers;

import com.training.weatherservice.dtos.Response;
import com.training.weatherservice.dtos.WeatherDataDTO;
import com.training.weatherservice.interceptors.ExceptionInterceptor;
import com.training.weatherservice.services.WeatherDataService;
import com.training.weatherservice.utilities.JsonUtility;
import com.training.weatherservice.utilities.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherDataControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private WeatherDataController controller;

    @Mock
    private WeatherDataService service;

    @Mock
    private ResponseBuilder builder;

    @Before
    public void init() {
        ResponseBuilder builder = new ResponseBuilder();

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new ExceptionInterceptor(builder))
                .build();
    }

    @Test
    public void findAll() throws Exception {
        WeatherDataDTO response = new WeatherDataDTO();

        List<WeatherDataDTO> weatherDataDTOS = Collections.singletonList(response);

        when(service.findAll()).thenReturn(weatherDataDTOS);
        when(builder.success(weatherDataDTOS)).thenReturn(Response.init().status(OK.value()).data(weatherDataDTOS).build());

        mockMvc.perform(get("/weather"))
                .andExpect(status().isOk());

        verify(service, times(1)).findAll();

        verifyNoMoreInteractions(service);
    }

    @Test
    public void findById() throws Exception {
        Long id = 1L;
        WeatherDataDTO response = new WeatherDataDTO();

        when(service.findById(id)).thenReturn(response);
        when(builder.success(response)).thenReturn(Response.init().status(OK.value()).data(response).build());

        mockMvc.perform(get("/weather/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).findById(1L);

        verifyNoMoreInteractions(service);
    }

    @Test
    public void findByDate() throws Exception {
        List<WeatherDataDTO> response = Collections.singletonList(new WeatherDataDTO());

        when(service.findByDate(any(LocalDate.class))).thenReturn(response);
        when(builder.success(response)).thenReturn(Response.init().status(OK.value()).data(response).build());

        mockMvc.perform(get("/weather").param("date", "2020-10-10"))
                .andExpect(status().isOk());

        verify(service, times(1)).findByDate(any(LocalDate.class));

        verifyNoMoreInteractions(service);
    }

    @Test
    public void saveOrUpdate() throws Exception {
        WeatherDataDTO dto = new WeatherDataDTO();

        doNothing().when(service).saveOrUpdate(dto);
        when(builder.success()).thenReturn(Response.init().status(OK.value()).data(OK.value()).build());

        mockMvc.perform(
                post("/weather")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(JsonUtility.toStringFormat(dto)))
        ).andExpect(status().isCreated());

        verify(service, times(1)).saveOrUpdate(dto);

        verifyNoMoreInteractions(service);
    }

    @Test
    public void deleteById() throws Exception {
        doNothing().when(service).deleteAll();
        when(builder.success()).thenReturn(Response.init().status(OK.value()).data(OK.value()).build());

        mockMvc.perform(delete("/weather")).andExpect(status().isOk());

        verify(service, times(1)).deleteAll();

        verifyNoMoreInteractions(service);
    }

    @Test
    public void deleteAll() throws Exception {
        Long id = 1L;

        doNothing().when(service).deleteById(id);
        when(builder.success()).thenReturn(Response.init().status(OK.value()).data(OK.value()).build());

        mockMvc.perform(delete("/weather/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteById(1L);

        verifyNoMoreInteractions(service);
    }
}