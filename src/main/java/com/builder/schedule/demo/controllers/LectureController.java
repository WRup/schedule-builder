package com.builder.schedule.demo.controllers;

import com.builder.schedule.demo.common.SuccessMessage;
import com.builder.schedule.demo.services.business.logic.LectureService;
import com.builder.schedule.demo.services.dto.LectureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping("/postLecture")
    public ResponseEntity<SuccessMessage> postLecture(@RequestBody LectureDto dto) {
        lectureService.save(dto);
        return ResponseEntity.ok(new SuccessMessage("Data successfully changed"));
    }
}
