package com.builder.schedule.demo.services.assembler;

import com.builder.schedule.demo.model.Auditorium;
import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.services.dto.LectureDto;

public class LectureAssembler {

    private LectureAssembler() {

    }

    public static Lecture toEntity(LectureDto dto, WorkerInSubject workerInSubject, Group group, Auditorium auditorium) {
        Lecture entity = new Lecture();


        entity.setId(dto.getId());
        entity.setWorkerInSubject(workerInSubject);
        entity.setAuditorium(auditorium);
        entity.setGroup(group);
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

        return entity;
    }


}
