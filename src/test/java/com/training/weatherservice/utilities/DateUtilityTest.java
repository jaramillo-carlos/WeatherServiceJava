package com.training.weatherservice.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilityTest {

    @Test
    void currentDate() {
        assertNotNull(DateUtility.currentDate());
    }
}
