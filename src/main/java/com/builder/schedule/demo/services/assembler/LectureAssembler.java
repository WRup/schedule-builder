package com.builder.schedule.demo.services.assembler;

import com.builder.schedule.demo.enumexample.Days;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.services.dto.LectureDto;

import java.util.Date;

public class LectureAssembler {

    public static Lecture toEntity(LectureDto dto, WorkerInSubject workerInSubject) {
        Lecture entity = new Lecture();


        entity.setId(dto.getId());
        entity.setWorkerInSubject(workerInSubject);
        entity.setAuditorium(null);
        entity.setGroup(null);
        entity.setDate(new Date(125325));
        entity.setDays(Days.MONDAY);

        return entity;
    }
}
