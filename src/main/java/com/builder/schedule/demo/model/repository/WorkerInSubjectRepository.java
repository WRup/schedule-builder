package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.WorkerInSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface WorkerInSubjectRepository extends CrudRepository<WorkerInSubject, Long> {
    @Override
    Set<WorkerInSubject> findAll();
}
