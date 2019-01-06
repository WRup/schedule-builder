package com.builder.schedule.demo.services.dto;

import lombok.Data;

@Data
public class LectureDto {

    private Long id;

    private String name;
    private String type;

    private String workerName;
    private String workerSurname;

    private String startTime;
    private String dayOfWeek;

    private String groupName;
    private String auditoruim;
}
