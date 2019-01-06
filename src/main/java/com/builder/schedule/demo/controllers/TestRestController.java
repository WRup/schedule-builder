package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.services.business.logic.LectureService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TestRestController {

    private final LectureService lectureService;

    public TestRestController(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @GetMapping(value = "/getLectures", produces = "application/json")
    public List<Lecture> lectures() {
        return lectureService.findAll();
    }

    //    @GetMapping(value = "/getLecture/{lectureId}")
    //    public Lecture lecture() {
    //        //return lectureService.findById(lectureId)
    //    }
}
