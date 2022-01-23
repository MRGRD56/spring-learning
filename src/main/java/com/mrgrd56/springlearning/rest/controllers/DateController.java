package com.mrgrd56.springlearning.rest.controllers;

import com.mrgrd56.springlearning.rest.dto.DateDto;
import com.mrgrd56.springlearning.rest.services.DateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
public class DateController {
    private final DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping
    public DateDto getCurrentDate() {
        return dateService.getCurrentDate();
    }
}
