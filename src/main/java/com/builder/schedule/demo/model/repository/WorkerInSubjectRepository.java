package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.WorkerInSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerInSubjectRepository extends JpaRepository<WorkerInSubject, Long> {

    @Query("select wis from WorkerInSubject wis where wis.subject = :subject and wis.worker = :worker")
    WorkerInSubject findBySubjectAndWorker(@Param("subject") String subject, @Param("worker") String worker);
}
