package com.builder.schedule.demo.services.map;


import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.services.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubjectMapService extends AbstractMapService<Subject, Long> implements SubjectService {
    @Override
    public Set<Subject> findAll() {
        return super.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Subject save(Subject object) {
        return super.save(object);
    }

    @Override
    public void delete(Subject object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
