package com.training.weatherservice.utilities;

import com.training.weatherservice.dtos.ExceptionBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.powermock.api.mockito.PowerMockito.mock;

class JsonUtilityTest {

    @Test
    void toStringFormat() {
        ExceptionBody exceptionBody = ExceptionBody.init().build();
        Assertions.assertEquals(exceptionBody.toString(), JsonUtility.toStringFormat(exceptionBody));
    }

    @Test
    void toStringFormatThrowException() {
        Assertions.assertNull(JsonUtility.toStringFormat(mock(ExceptionBody.class)));
    }
}
