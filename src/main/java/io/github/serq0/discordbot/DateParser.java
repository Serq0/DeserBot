package io.github.serq0.discordbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser {
    private static final Logger log = LoggerFactory.getLogger(DateParser.class);
    private String dateFormat;

    public Date getDateFromString(String dateString) {
        Date date = null;
        try {
            date = getSimpleDateFormat().parse(dateString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return date;
    }

    public Calendar getCalendarFromString(String dateString) {
        Date date = getDateFromString(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat(getDateFormat());
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
