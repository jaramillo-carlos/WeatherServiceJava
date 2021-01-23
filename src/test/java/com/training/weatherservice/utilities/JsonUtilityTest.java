package com.training.weatherservice.utilities;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.training.weatherservice.dtos.ExceptionBody;
import com.training.weatherservice.dtos.Response;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;


public class JsonUtilityTest {

    @Test
    public void toStringFormat() {
        ExceptionBody exceptionBody = ExceptionBody.init().build();
        Assert.assertEquals(exceptionBody.toString(), JsonUtility.toStringFormat(exceptionBody));
    }

    @Test(expected = InvalidDefinitionException.class)
    public void toStringFormatThrowException() {
        JsonUtility.toStringFormat(mock(Response.class));
    }
}
