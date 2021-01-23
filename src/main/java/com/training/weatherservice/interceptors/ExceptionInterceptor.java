package com.training.weatherservice.interceptors;

import com.training.weatherservice.dtos.ExceptionBody;
import com.training.weatherservice.dtos.Response;
import com.training.weatherservice.exceptions.DuplicatedException;
import com.training.weatherservice.exceptions.NotFound;
import com.training.weatherservice.utilities.ExceptionBuilder;
import com.training.weatherservice.utilities.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ResponseBody
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionInterceptor {

    public static final String MESSAGE = "An error has occurred in the server. {}";
    private final ResponseBuilder builder;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exception(Exception exception) {
        log.error(MESSAGE, ExceptionBuilder.init(exception).build());

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(builder.failed(MESSAGE));
    }

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<Response> duplicatedException(DuplicatedException exception) {
        log.error(MESSAGE, ExceptionBuilder.init(exception).build());

        return ResponseEntity.status(BAD_REQUEST).body(builder.failed(exception));
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Response> notFoundException(Exception exception) {
        ExceptionBody exceptionBody = ExceptionBuilder.init(exception).build();

        log.error(MESSAGE, exceptionBody);

        return ResponseEntity.status(NOT_FOUND).body(builder.failed(exceptionBody, NOT_FOUND));
    }
}
