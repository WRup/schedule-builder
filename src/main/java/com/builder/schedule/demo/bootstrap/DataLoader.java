package com.builder.schedule.demo.bootstrap;

import com.builder.schedule.demo.services.business.logic.SubjectService;
import com.builder.schedule.demo.services.business.logic.WorkerService;
import com.builder.schedule.demo.services.business.logic.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final YearService yearService;
    private final WorkerService workerService;
    private final SubjectService subjectService;

    @Autowired
    public DataLoader(YearService yearService, WorkerService workerService, SubjectService subjectService) {
        this.yearService = yearService;
        this.workerService = workerService;
        this.subjectService = subjectService;
    }


    @Override
    public void run(String... args) throws Exception {
    }

    private void loadData() {
    }
}
