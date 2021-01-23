package com.training.weatherservice.dtos;

import lombok.Builder;
import lombok.Data;

import static com.training.weatherservice.utilities.JsonUtility.toStringFormat;

@Data
@Builder(builderMethodName = "init")
public class ExceptionBody {

    private String date;
    private String line;
    private String clazz;
    private String method;
    private String message;
    private String endpoint;
    private String exceptionName;
    private String messageDetail;
    private Object additionalInformation;

    @Override
    public String toString() {
        return toStringFormat(this);
    }
}

