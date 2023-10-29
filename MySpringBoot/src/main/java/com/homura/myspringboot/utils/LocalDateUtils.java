package com.homura.myspringboot.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateUtils {
    private static final String LOCAL_TIME_PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * 获得时间
     *
     * @return
     */
    public static String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(LOCAL_TIME_PATTERN).format(now);
    }

}
