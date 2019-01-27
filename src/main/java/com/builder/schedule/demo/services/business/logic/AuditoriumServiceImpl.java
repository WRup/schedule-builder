package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.common.DateConverter;
import com.builder.schedule.demo.model.Auditorium;
import com.builder.schedule.demo.model.repository.AuditoriumRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public List<Auditorium> findAll() {
        return auditoriumRepository.findAll();
    }

    @Override
    public Auditorium findById(Long aLong) {
        return auditoriumRepository.findById(aLong).orElse(null);
    }

    @Override
    public Auditorium save(Auditorium object) {
        return auditoriumRepository.save(object);
    }

    @Override
    public void delete(Auditorium object) {
        auditoriumRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        auditoriumRepository.deleteById(aLong);
    }

    @Override
    public Auditorium findByName(String name) {
        return auditoriumRepository.findByName(name);
    }

    @Override
    public List<Long> findOccupiedAuditorium(String date) throws ParseException {
        DateConverter dateConverter = new DateConverter();
        Date startDate = dateConverter.convertDate(date.split(",")[0]);
        Date endDate = dateConverter.convertDate(date.split(",")[1]);

        System.out.println(startDate);
        System.out.println(endDate);

        return auditoriumRepository.findOccupiedAuditoriums(startDate, endDate);
    }
}
