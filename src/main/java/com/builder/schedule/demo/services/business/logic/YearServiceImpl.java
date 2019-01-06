package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.Year;
import com.builder.schedule.demo.model.repository.YearRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;

    public YearServiceImpl(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    @Override
    public List<Year> findAll() {
        return yearRepository.findAll();
    }

    @Override
    public Year findById(Long aLong) {
        return null;
    }

    @Override
    public Year save(Year object) {
        return yearRepository.save(object);
    }

    @Override
    public void delete(Year object) {
        yearRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        yearRepository.deleteById(aLong);
    }
}
