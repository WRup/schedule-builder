package com.builder.schedule.demo.services.map;

import com.builder.schedule.demo.model.Year;
import com.builder.schedule.demo.services.YearService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class YearMapService extends AbstractMapService<Year, Long> implements YearService {
    @Override
    public Set<Year> findAll() {
        return super.findAll();
    }

    @Override
    public Year findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Year save(Year object) {
        return super.save(object);
    }

    @Override
    public void delete(Year object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
