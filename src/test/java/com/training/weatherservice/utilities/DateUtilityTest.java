package com.training.weatherservice.utilities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DateUtilityTest {
    @Test
    public void currentDate() {
        Assert.assertNotNull(DateUtility.currentDate());
    }
}
