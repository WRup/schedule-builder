package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.services.business.logic.BuildingService;
import com.builder.schedule.demo.services.business.logic.LectureService;
import com.builder.schedule.demo.services.business.logic.YearService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    private final LectureService lectureService;
    private final YearService yearService;
    private final BuildingService buildingService;

    public CalendarController(LectureService lectureService, YearService yearService, BuildingService buildingService) {
        this.lectureService = lectureService;
        this.yearService = yearService;
        this.buildingService = buildingService;
    }

    @GetMapping("/schedulerAdmin")
    public String index(Model model) {
        generateDataModel(model);
        return "admin/schedulerAdmin";
    }

    private void generateDataModel(Model model) {
        model.addAttribute("lectures_event", lectureService.findLecturesByStartDateIsNotNull());
        model.addAttribute("years", yearService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        model.addAttribute("lectures_external", lectureService.findLecturesByStartDateIsNull());
    }

    @GetMapping("/schedulerWorker")
    public String renderWorkerScheduler(Model model) {
        generateDataModel(model);
        return "worker/schedulerWorker";
    }

    @GetMapping("/schedulerRead")
    public String renderReadScheduler(Model model) {
        generateDataModel(model);
        return "common/schedulerRead";
    }
}
