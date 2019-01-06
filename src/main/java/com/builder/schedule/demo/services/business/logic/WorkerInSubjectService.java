package com.builder.schedule.demo.services.business.logic;

import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;


public interface WorkerInSubjectService extends CrudService<WorkerInSubject, Long> {
    WorkerInSubject findBySubjectAndWorker(Subject subject, Worker worker);
}
