package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.repository.LectureRepository;
import com.builder.schedule.demo.services.assembler.LectureAssembler;
import com.builder.schedule.demo.services.dto.LectureDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final WorkerService workerService;
    private final SubjectService subjectService;
    private final WorkerInSubjectService workerInSubjectService;
    private final GroupService groupService;
    //reposy pozostalych potrzebnych obiektow

    public LectureServiceImpl(LectureRepository lectureRepository, WorkerService workerService, SubjectService subjectService, WorkerInSubjectService workerInSubjectService, GroupService groupService) {
        this.lectureRepository = lectureRepository;
        this.workerService = workerService;
        this.subjectService = subjectService;
        this.workerInSubjectService = workerInSubjectService;
        this.groupService = groupService;
    }

    @Override
    @Transactional
    public void save(LectureDto dto) {
        Group group = groupService.findById(dto.getGroupId());
        Worker worker = workerService.findByNameAndSurname(dto.getWorkerName(), dto.getWorkerSurname());
        Subject subject = subjectService.findByNameAndType(dto.getSubjectName(), dto.getSubjectType());
        WorkerInSubject workerInSubject = workerInSubjectService.findBySubjectAndWorker(subject, worker);
        lectureRepository.save(LectureAssembler.toEntity(dto, workerInSubject, group));
    }

    @Override
    @Transactional
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    @Transactional
    public Lecture findById(Long aLong) {
        return lectureRepository.findById(aLong).orElse(null);
    }
}
