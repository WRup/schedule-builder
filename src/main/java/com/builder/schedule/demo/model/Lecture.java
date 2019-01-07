package com.builder.schedule.demo.model;

import com.builder.schedule.demo.enumexample.Days;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LECTURE")
@Data
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_time")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private Days days;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_group_id")
    private Group group;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_subject_id", nullable = false)
    private WorkerInSubject workerInSubject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    public Lecture(WorkerInSubject workerInSubject) {
        this.workerInSubject = workerInSubject;
    }

    public Lecture() {
    }
}
