package ru.otus.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tully.
 */
class TimeServiceSingleton {
    private static final String DEFAULT_PATTERN = "HH:mm:ss";
    private static TimeServiceSingleton timeService;

    private final String pattern;

    private TimeServiceSingleton(String pattern) {
        this.pattern = pattern;
    }

    static TimeServiceSingleton instance() {
        if (timeService == null) {
            timeService = new TimeServiceSingleton(DEFAULT_PATTERN);
        }
        return timeService;
    }

    String getTime() {
        Date date = new Date();
        date.getTime();
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}
