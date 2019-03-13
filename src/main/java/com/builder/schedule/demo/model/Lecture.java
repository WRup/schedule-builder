package com.builder.schedule.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LECTURE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_time")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "note")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_group_id")
    private Group group;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_subject_id", nullable = false)
    private WorkerInSubject workerInSubject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    public Lecture(WorkerInSubject workerInSubject) {
        this.workerInSubject = workerInSubject;
    }
}
