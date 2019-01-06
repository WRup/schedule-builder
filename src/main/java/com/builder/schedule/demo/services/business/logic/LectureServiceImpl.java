package com.builder.schedule.demo.services.business.logic;


import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.repository.LectureRepository;
import com.builder.schedule.demo.services.assembler.LectureAssembler;
import com.builder.schedule.demo.services.dto.LectureDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    @Transactional
    public void save(LectureDto dto) {
        lectureRepository.save(LectureAssembler.toEntity(dto));
    }

    @Override
    @Transactional
    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }
}
