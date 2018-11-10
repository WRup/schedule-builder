package com.builder.schedule.demo.services.map;

import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.services.LectureService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LectureMapService extends AbstractMapService<Lecture, Long> implements LectureService {
    @Override
    public Set<Lecture> findAll() {
        return super.findAll();
    }

    @Override
    public Lecture findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Lecture save(Lecture object) {
        return super.save(object);
    }

    @Override
    public void delete(Lecture object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
