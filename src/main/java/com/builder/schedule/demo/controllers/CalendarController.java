package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.services.LectureService;
import com.builder.schedule.demo.services.SubjectService;
import com.builder.schedule.demo.services.YearService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarController {

    private final LectureService lectureService;
    private final YearService yearService;
    private final SubjectService subjectService;

    public CalendarController(LectureService lectureService, YearService yearService, SubjectService subjectService) {
        this.lectureService = lectureService;
        this.yearService = yearService;
        this.subjectService = subjectService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calendar")
    public String index(Model model) {
        model.addAttribute("lectures", lectureService.findAll());
        model.addAttribute("years", yearService.findAll());
        //model.addAttribute("subjects", subjectService.findAll());
        return "calendar/calendar";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLectures")
    public String getLectures(Model model) {
        model.addAttribute("lectures", lectureService.findAll());
        model.addAttribute("years", yearService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "lectures/index";
    }

}
