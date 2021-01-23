package com.training.weatherservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "init")
public class Response {
    private Object data;
    private Integer status;
}
