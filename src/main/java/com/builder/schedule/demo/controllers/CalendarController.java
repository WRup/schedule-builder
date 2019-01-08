package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.common.SuccessMessage;
import com.builder.schedule.demo.services.business.logic.BuildingService;
import com.builder.schedule.demo.services.business.logic.LectureService;
import com.builder.schedule.demo.services.business.logic.YearService;
import com.builder.schedule.demo.services.dto.LectureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(method = RequestMethod.GET, value = "/scheduler")
    public String index(Model model) {
        model.addAttribute("lectures", lectureService.findAll());
        model.addAttribute("years", yearService.findAll());
        model.addAttribute("buildings", buildingService.findAll());
        return "calendar/scheduler";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/postLecture")
    public ResponseEntity<SuccessMessage> postLecture(@RequestBody LectureDto dto) {
        lectureService.save(dto);
        return ResponseEntity.ok(new SuccessMessage("Data successfully changed"));
    }

}
