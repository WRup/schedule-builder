package com.builder.schedule.demo.bootstrap;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Year;
import com.builder.schedule.demo.services.SubjectService;
import com.builder.schedule.demo.services.WorkerService;
import com.builder.schedule.demo.services.YearService;
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
        loadData();
    }

    private void loadData() {
        Year year = new Year();
        Group group = new Group();
        group.setName("GR1");
        group.setType("L");
        group.setYear(year);


        year.getGroups().add(group);
        year.setName("I");
        year.setStudents("123");
        year.setTerm("I");
        year.setNumberOfGroups("6");

        yearService.save(year);
        System.out.println("new group created");
    }
}
