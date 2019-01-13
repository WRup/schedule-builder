package com.builder.schedule.demo.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LectureDto {

    private Long id;

    private String subjectName;
    private String subjectType;

    private String workerName;
    private String workerSurname;

    private Date startDate;
    private Date endDate;

    private String dayOfWeek;

    private Long groupId;
    private String auditoriumName;
}
