package com.training.weatherservice.interceptors;

import com.training.weatherservice.dtos.ExceptionBody;
import com.training.weatherservice.dtos.Response;
import com.training.weatherservice.exceptions.DuplicatedException;
import com.training.weatherservice.exceptions.NotFound;
import com.training.weatherservice.utilities.ExceptionBuilder;
import com.training.weatherservice.utilities.ResponseBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RunWith(PowerMockRunner.class)
public class ExceptionInterceptorTest {

    @InjectMocks
    private ExceptionInterceptor interceptor;

    @Mock
    private ResponseBuilder builder;

    @Test
    @PrepareOnlyThisForTest(ExceptionBuilder.class)
    public void exception() {
        mockStatic(ExceptionBuilder.class);
        Exception exception = new Exception();
        ExceptionBuilder exceptionBuilder = mock(ExceptionBuilder.class);
        ExceptionBody exceptionBody = mock(ExceptionBody.class);

        when(ExceptionBuilder.init(exception)).thenReturn(exceptionBuilder);
        when(exceptionBuilder.build()).thenReturn(exceptionBody);

        Assert.assertNotNull(interceptor.exception(exception));
    }

    @Test
    @PrepareOnlyThisForTest(ExceptionBuilder.class)
    public void duplicatedException() {
        mockStatic(ExceptionBuilder.class);
        DuplicatedException exception = new DuplicatedException();
        ExceptionBuilder exceptionBuilder = mock(ExceptionBuilder.class);
        ExceptionBody exceptionBody = mock(ExceptionBody.class);

        when(ExceptionBuilder.init(exception)).thenReturn(exceptionBuilder);
        when(exceptionBuilder.build()).thenReturn(exceptionBody);

        Assert.assertNotNull(interceptor.duplicatedException(exception));
    }

    @Test
    @PrepareOnlyThisForTest(ExceptionBuilder.class)
    public void notFoundException() {
        NotFound exception = new NotFound();
        ExceptionBuilder exceptionBuilder = mock(ExceptionBuilder.class);
        ExceptionBody exceptionBody = mock(ExceptionBody.class);
        Response response = mock(Response.class);

        mockStatic(ExceptionBuilder.class);

        when(ExceptionBuilder.init(exception)).thenReturn(exceptionBuilder);
        when(exceptionBuilder.build()).thenReturn(exceptionBody);
        when(builder.failed(exceptionBody, NOT_FOUND)).thenReturn(response);

        Assert.assertEquals(interceptor.notFoundException(exception).getBody(), response);
    }
}
