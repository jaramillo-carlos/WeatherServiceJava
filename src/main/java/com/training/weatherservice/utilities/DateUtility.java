package com.training.weatherservice.utilities;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateUtility {

    private static final String ZONE_ID = "GMT-5";

    public static LocalDateTime currentDate() {
        return LocalDateTime.now(ZoneId.of(ZONE_ID));
    }
}
