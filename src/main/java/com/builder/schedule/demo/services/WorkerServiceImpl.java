package com.builder.schedule.demo.services;


import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Set<Worker> findAll() {
        return null;
    }

    @Override
    public Worker findById(Long aLong) {
        return null;
    }

    @Override
    public Worker save(Worker object) {
        return null;
    }

    @Override
    public void delete(Worker object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
