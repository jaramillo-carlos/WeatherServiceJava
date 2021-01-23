package com.training.weatherservice.utilities;

import com.training.weatherservice.dtos.ExceptionBody;
import org.junit.Assert;
import org.junit.Test;

import static org.powermock.api.mockito.PowerMockito.mock;

public class JsonUtilityTest {

    @Test
    public void toStringFormat() {
        ExceptionBody exceptionBody = ExceptionBody.init().build();
        Assert.assertEquals(exceptionBody.toString(), JsonUtility.toStringFormat(exceptionBody));
    }

    @Test
    public void toStringFormatThrowException() {
        Assert.assertNotNull(JsonUtility.toStringFormat(mock(ExceptionBody.class)));
    }
}
