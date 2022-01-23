package com.mrgrd56.springlearning.rest.services;

import com.mrgrd56.springlearning.rest.dto.DateDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class DateService {
    public DateDto getCurrentDate() {
        return new DateDto(LocalDateTime.now().atZone(ZoneId.systemDefault()));
    }
}
