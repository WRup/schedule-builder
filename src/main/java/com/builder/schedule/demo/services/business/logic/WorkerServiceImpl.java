package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findById(Long aLong) {
        return null;
    }

    @Override
    public Worker save(Worker object) {
        return workerRepository.save(object);
    }

    @Override
    public void delete(Worker object) {
        workerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        workerRepository.deleteById(aLong);
    }

    public Worker findByNameAndSurname(String name, String surname) {
        return workerRepository.findByNameAndSurname(name, surname);
    }
}
