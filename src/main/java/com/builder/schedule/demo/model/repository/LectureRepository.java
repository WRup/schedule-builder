package com.builder.schedule.demo.model.repository;


import com.builder.schedule.demo.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("select lec from Lecture lec where lec.startDate is null")
    List<Lecture> findLecturesByStartDateIsNull();

    @Query("select lec from Lecture lec where lec.startDate is not null")
    List<Lecture> findLecturesByStartDateIsNotNull();

}
