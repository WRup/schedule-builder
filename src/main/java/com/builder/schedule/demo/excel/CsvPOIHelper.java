package com.builder.schedule.demo.excel;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.Year;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvPOIHelper {


    public List<ArrayList> readCsv(String filepath) {
        List<ArrayList> lists = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<Year> years = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();
        ArrayList<Lecture> lectures = new ArrayList<>();
        ArrayList<WorkerInSubject> workerInSubjects = new ArrayList<>();
        Subject subject;
        Worker worker;
        Year year;
        WorkerInSubject workerInSubject;
        subject = new Subject();
        year = new Year();

        try (Reader reader = Files.newBufferedReader(Paths.get(filepath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                worker = new Worker();
                workerInSubject = new WorkerInSubject();
                // Accessing values by the names assigned to each column
                if(csvRecord.getRecordNumber() == 0) {
                    year.setName(csvRecord.get(0));
                    year.setTerm(csvRecord.get(1));
                    year.setStudents(csvRecord.get(2));
                    years.add(year);
                } else if(csvRecord.getRecordNumber() == 1) {
                    subject.setName(csvRecord.get(0));
                    System.out.println(csvRecord.get(0));
                    subject.setType(csvRecord.get(1));
                    System.out.println(csvRecord.get(1));
                    subject.setNumberOfGroups(csvRecord.get(2));
                    System.out.println(csvRecord.get(2));
                    subject.setHours(csvRecord.get(3));
                    subjects.add(subject);
                    groups = checkGroups(subject, groups, year);
                } else if(csvRecord.getRecordNumber() >= 2) {
                    worker.setName(csvRecord.get(0));
                    worker.setSurname(csvRecord.get(1));
                    workers.add(worker);
                    workerInSubject.setSubject(subject);
                    workerInSubject.setWorker(worker);
                    workerInSubject.setHours(csvRecord.get(2));
                    workerInSubjects.add(workerInSubject);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WorkerInSubject wis : workerInSubjects) {
            lectures.add(new Lecture(wis));
        }

        lists.add(subjects);
        lists.add(workers);
        lists.add(years);
        lists.add(groups);
        lists.add(workerInSubjects);
        lists.add(lectures);


        return lists;
    }

    private ArrayList<Group> checkGroups(Subject subject, ArrayList<Group> arrayList, Year year) {
        boolean checker = false;
        for (Group group : arrayList) {
            if(group.getType().equals(subject.getType())) {
                checker = true;
                break;
            }
        }
        if(arrayList.isEmpty() || !checker) {
            for (int i = 1; i <= Integer.valueOf(subject.getNumberOfGroups()); i++) {
                arrayList.add(new Group(i + subject.getType(), subject.getType(), year));
            }
        }
        return arrayList;
    }
}
