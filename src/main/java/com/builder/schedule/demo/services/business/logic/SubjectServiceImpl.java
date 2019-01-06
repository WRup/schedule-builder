package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long aLong) {
        return subjectRepository.findById(aLong).orElse(null);
    }

    @Override
    public Subject save(Subject object) {
        return subjectRepository.save(object);
    }

    @Override
    public void delete(Subject object) {
        subjectRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        subjectRepository.deleteById(aLong);
    }
}
