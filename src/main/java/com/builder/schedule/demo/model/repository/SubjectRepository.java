package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

    @Override
    Set<Subject> findAll();
}
