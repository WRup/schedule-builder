package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.repository.WorkerInSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerInSubjectServiceImpl implements WorkerInSubjectService {

    private final WorkerInSubjectRepository workerInSubjectRepository;

    public WorkerInSubjectServiceImpl(WorkerInSubjectRepository workerInSubjectRepository) {
        this.workerInSubjectRepository = workerInSubjectRepository;
    }


    @Override
    public List<WorkerInSubject> findAll() {
        return workerInSubjectRepository.findAll();
    }

    @Override
    public WorkerInSubject findById(Long aLong) {
        return workerInSubjectRepository.findById(aLong).orElse(null);
    }

    @Override
    public WorkerInSubject save(WorkerInSubject object) {
        return workerInSubjectRepository.save(object);
    }

    @Override
    public void delete(WorkerInSubject object) {
        workerInSubjectRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        workerInSubjectRepository.deleteById(aLong);
    }

    @Override
    public WorkerInSubject findBySubjectAndWorker(Subject subject, Worker worker) {
        return workerInSubjectRepository.findBySubjectAndWorker(subject, worker);
    }
}
