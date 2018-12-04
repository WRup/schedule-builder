package com.builder.schedule.demo.services;


import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Set<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long aLong) {
        return null;
    }

    @Override
    public Subject save(Subject object) {
        return null;
    }

    @Override
    public void delete(Subject object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
