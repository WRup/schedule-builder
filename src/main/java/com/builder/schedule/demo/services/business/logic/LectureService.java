package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.services.dto.LectureDto;

import java.util.Set;

public interface LectureService {

    void save(LectureDto dto);

    Set<Lecture> findAll();
}
