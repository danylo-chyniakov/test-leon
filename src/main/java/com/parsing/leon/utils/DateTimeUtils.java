package com.parsing.leon.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");

    public static String getKickOffAsUTC(String kickoffAsEpoch) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(kickoffAsEpoch));

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        return localDateTime.format(DateTimeUtils.DATE_TIME_FORMATTER);
    }
}
