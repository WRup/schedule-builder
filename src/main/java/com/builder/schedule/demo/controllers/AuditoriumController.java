package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.services.business.logic.AuditoriumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @GetMapping("/getOccupiedAuditoriums/{date}")
    public List<Long> getOccupiedAuditoriums(@PathVariable String date) throws ParseException {
        return auditoriumService.findOccupiedAuditorium(date);
    }
}
