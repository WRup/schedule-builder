package com.builder.schedule.demo.services;


import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Set<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    public Lecture findById(Long aLong) {
        return null;
    }

    @Override
    public Lecture save(Lecture object) {
        return null;
    }

    @Override
    public void delete(Lecture object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
