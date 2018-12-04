package com.builder.schedule.demo.model;

import com.builder.schedule.demo.enumexample.Days;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "LECTURE")
public class Lecture extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_time")
    private Date date;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public WorkerInSubject getWorkerInSubject() {
        return workerInSubject;
    }

    public void setWorkerInSubject(WorkerInSubject workerInSubject) {
        this.workerInSubject = workerInSubject;
    }
}
