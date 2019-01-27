package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Auditorium;

import java.text.ParseException;
import java.util.List;

public interface AuditoriumService extends CrudService<Auditorium, Long> {
    Auditorium findByName(String name);

    List<Long> findOccupiedAuditorium(String date) throws ParseException;
}
