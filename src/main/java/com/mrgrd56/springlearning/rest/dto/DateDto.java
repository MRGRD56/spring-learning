package com.mrgrd56.springlearning.rest.dto;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class DateDto {
    public DateDto(ZonedDateTime localDateTime) {
        year = localDateTime.getYear();
        month = localDateTime.getMonthValue();
        day = localDateTime.getDayOfMonth();
        hours = localDateTime.getHour();
        minutes = localDateTime.getMinute();
        seconds = localDateTime.getSecond();
        localDate = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        utcDate = localDateTime.withZoneSameInstant(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    int year;
    int month;
    int day;
    int hours;
    int minutes;
    int seconds;
    String localDate;
    String utcDate;
}
