package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.services.dto.LectureDto;

import java.util.List;

public interface LectureService {

    void save(LectureDto dto);

    List<Lecture> findAll();

    Lecture findById(Long aLong);

    List<Lecture> findLecturesByStartDateIsNull();

    List<Lecture> findLecturesByStartDateIsNotNull();
}
