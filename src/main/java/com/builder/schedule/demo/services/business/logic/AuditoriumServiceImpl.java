package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Auditorium;
import com.builder.schedule.demo.model.repository.AuditoriumRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public Set<Auditorium> findAll() {
        return null;
    }

    @Override
    public Auditorium findById(Long aLong) {
        return null;
    }

    @Override
    public Auditorium save(Auditorium object) {
        auditoriumRepository.save(object);
        return object;
    }

    @Override
    public void delete(Auditorium object) {
        auditoriumRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        auditoriumRepository.deleteById(aLong);
    }
}
