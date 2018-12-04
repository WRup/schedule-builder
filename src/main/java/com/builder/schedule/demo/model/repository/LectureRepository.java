package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {

    @Override
    Set<Lecture> findAll();
}
