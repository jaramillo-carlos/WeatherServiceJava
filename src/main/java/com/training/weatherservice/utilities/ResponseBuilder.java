package com.training.weatherservice.utilities;

import com.training.weatherservice.dtos.ExceptionBody;
import com.training.weatherservice.dtos.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ResponseBuilder {


    public Response success() {
        return Response
                .init()
                .status(OK.value())
                .data(OK.value())
                .build();
    }
    public Response success(Object data) {
        return Response
                .init()
                .status(OK.value())
                .data(data)
                .build();
    }

    public Response failed(Object data) {
        return Response
                .init()
                .status(INTERNAL_SERVER_ERROR.value())
                .data(data)
                .build();
    }

    public Response failed(ExceptionBody exceptionBody) {
        return Response
                .init()
                .status(INTERNAL_SERVER_ERROR.value())
                .data(
                        Optional
                                .ofNullable(exceptionBody.getAdditionalInformation())
                                .orElse(exceptionBody.getMessage())
                )
                .build();
    }

    public Response failed(ExceptionBody exceptionBody, int status) {
        return Response
                .init()
                .status(status)
                .data(
                        Optional
                                .ofNullable(exceptionBody.getAdditionalInformation())
                                .orElse(exceptionBody.getMessage())
                )
                .build();
    }

    public Response failed(ExceptionBody exceptionBody, HttpStatus status) {
        return Response
                .init()
                .status(status.value())
                .data(
                        Optional
                                .ofNullable(exceptionBody.getAdditionalInformation())
                                .orElse(exceptionBody.getMessage())
                )
                .build();
    }
}
