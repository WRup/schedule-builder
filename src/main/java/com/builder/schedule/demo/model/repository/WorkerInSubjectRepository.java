package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.WorkerInSubject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface WorkerInSubjectRepository extends CrudRepository<WorkerInSubject, Long> {
    @Override
    Set<WorkerInSubject> findAll();

    @Query("select wis from WorkerInSubject wis where wis.subject = :subject and wis.worker = :worker")
    WorkerInSubject findBySubjectAndWorker(@Param("subject") String subject, @Param("worker") String worker);
}
