package com.training.weatherservice.utilities;

import com.training.weatherservice.dtos.ExceptionBody;
import com.training.weatherservice.dtos.Response;
import com.training.weatherservice.exceptions.NotFound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

public class ResponseBuilderTest {

    private ResponseBuilder builder;

    @Before
    public void init() {
        builder = new ResponseBuilder();
    }

    @Test
    public void successTest() {
        Assert.assertEquals(
                Response
                        .init()
                        .status(OK.value())
                        .data(OK.value())
                        .build(),
                builder.success()
        );
    }

    @Test
    public void successObjectTest() {
        ExceptionBody object = ExceptionBody.init().build();

        Assert.assertEquals(
                Response
                        .init()
                        .status(OK.value())
                        .data(object)
                        .build(),
                builder.success(object)
        );
    }

    @Test
    public void failedExceptionTest() {
        NotFound exception = new NotFound();

        ExceptionBody exceptionBody = ExceptionBody
                .init()
                .message(exception.getMessage())
                .build();

        Assert.assertEquals(
                Response
                        .init()
                        .status(INTERNAL_SERVER_ERROR.value())
                        .data(exception.getMessage())
                        .build(),
                builder.failed(exceptionBody)
        );
    }

    @Test
    public void failedTest() {
        NotFound exception = new NotFound();

        ExceptionBody exceptionBody = ExceptionBody
                .init()
                .message(exception.getMessage())
                .build();

        Assert.assertEquals(
                Response
                        .init()
                        .status(INTERNAL_SERVER_ERROR.value())
                        .data(exception.getMessage())
                        .build(),
                builder.failed(exceptionBody, INTERNAL_SERVER_ERROR.value())
        );
    }

    @Test
    public void failedMessageTest() {
        String message = "message";

        Assert.assertEquals(
                Response
                        .init()
                        .status(INTERNAL_SERVER_ERROR.value())
                        .data(message)
                        .build(),
                builder.failed(message)
        );
    }

    @Test
    public void failedExceptionBodyTest() {
        NotFound exception = new NotFound();

        ExceptionBody exceptionBody = ExceptionBody
                .init()
                .message(exception.getMessage())
                .build();

        Assert.assertEquals(
                Response
                        .init()
                        .status(INTERNAL_SERVER_ERROR.value())
                        .data(exception.getMessage())
                        .build(),
                builder.failed(exceptionBody, INTERNAL_SERVER_ERROR)
        );
    }
}
