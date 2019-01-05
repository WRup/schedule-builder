package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.repository.WorkerInSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WorkerInSubjectServiceImpl implements WorkerInSubjectService {

    private final WorkerInSubjectRepository workerInSubjectRepository;

    public WorkerInSubjectServiceImpl(WorkerInSubjectRepository workerInSubjectRepository) {
        this.workerInSubjectRepository = workerInSubjectRepository;
    }


    @Override
    public Set<WorkerInSubject> findAll() {
        return workerInSubjectRepository.findAll();
    }

    @Override
    public WorkerInSubject findById(Long aLong) {
        return null;
    }

    @Override
    public WorkerInSubject save(WorkerInSubject object) {
        workerInSubjectRepository.save(object);
        return object;
    }

    @Override
    public void delete(WorkerInSubject object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
