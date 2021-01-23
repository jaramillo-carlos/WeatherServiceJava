package com.training.weatherservice.configurations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapperTest {
    @Test
    void modelMapper() {
        Mapper mapper = new Mapper();
        Assertions.assertNotNull(mapper.modelMapper());
    }
}
