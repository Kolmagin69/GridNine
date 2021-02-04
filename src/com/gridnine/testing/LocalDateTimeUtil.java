package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeUtil {

    public static long dateDifferenceSecond(LocalDateTime time, LocalDateTime time1) {
        ZonedDateTime zonedTime = time.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedTime1 = time1.atZone(ZoneId.systemDefault());
        return zonedTime1.toEpochSecond() - zonedTime.toEpochSecond();
    }
}
