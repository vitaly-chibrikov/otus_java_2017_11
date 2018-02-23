package ru.otus.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tully.
 */
public class TimeService {
    private static final String DEFAULT_PATTERN = "HH.mm.ss";

    private final String pattern;

    public TimeService() {
        this.pattern = DEFAULT_PATTERN;
    }

    public TimeService(String pattern) {
        this.pattern = pattern;
    }

    String getTime() {
        Date date = new Date();
        date.getTime();
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}
