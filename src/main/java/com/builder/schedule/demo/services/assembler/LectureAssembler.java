package com.builder.schedule.demo.services.assembler;

import com.builder.schedule.demo.enumexample.Days;
import com.builder.schedule.demo.model.Auditorium;
import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.services.dto.LectureDto;

import java.util.Date;

public class LectureAssembler {

    public static Lecture toEntity(LectureDto dto) {
        Lecture entity = new Lecture();
        Auditorium auditorium = new Auditorium();
        Group group = new Group();
        Worker worker = new Worker();
        Subject subject = new Subject();
        WorkerInSubject workerInSubject = new WorkerInSubject();

        group.setName(dto.getGroupName());
        auditorium.setName(dto.getAuditoruim());
        worker.setName(dto.getWorkerName());
        worker.setSurname(dto.getWorkerSurname());
        subject.setName(dto.getName());
        subject.setType(dto.getType());

        workerInSubject.setSubject(subject);
        workerInSubject.setWorker(worker);

        entity.setId(dto.getId());
        entity.setGroup(group);
        entity.setAuditorium(auditorium);
        entity.setWorkerInSubject(workerInSubject);
        entity.setDate(new Date(125325));
        entity.setDays(Days.MONDAY);

        return entity;
    }
}
