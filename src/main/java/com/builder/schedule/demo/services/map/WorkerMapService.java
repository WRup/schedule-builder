package com.builder.schedule.demo.services.map;

import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.services.WorkerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WorkerMapService extends AbstractMapService<Worker, Long> implements WorkerService {
    @Override
    public Set<Worker> findAll() {
        return super.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Worker save(Worker object) {
        return super.save(object);
    }

    @Override
    public void delete(Worker object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
