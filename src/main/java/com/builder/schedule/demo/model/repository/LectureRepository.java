package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {
}
