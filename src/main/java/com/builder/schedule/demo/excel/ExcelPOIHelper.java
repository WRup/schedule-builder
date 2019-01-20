package com.builder.schedule.demo.excel;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.Year;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelPOIHelper {

    public List<ArrayList> readExcel(XSSFSheet sheet) {

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
        year = new Year();
        subject = new Subject();
        boolean checker = false;
        for (Row row : sheet) {

            worker = new Worker();
            workerInSubject = new WorkerInSubject();
            if(row.cellIterator().next().getStringCellValue().equals("")) {
                checker = true;
                subject = new Subject();
                continue;
            }
            if(row.getRowNum() == 0) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            year.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            year.setTerm(cell.getStringCellValue());
                            break;
                        case 2:
                            year.setStudents(cell.getStringCellValue());
                            years.add(year);
                            break;
                        default:
                            break;
                    }
                }
            }

            if(row.getRowNum() == 1 || checker) {
                checker = false;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            subject.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            subject.setType(cell.getStringCellValue());
                            break;
                        case 2:
                            subject.setNumberOfGroups(cell.getStringCellValue());
                            break;
                        case 3:
                            subject.setHours(cell.getStringCellValue());
                            subjects.add(subject);
                            groups = checkGroups(subject, groups, year);
                            break;
                        default:
                            break;
                    }
                }
                continue;
            }
            if(row.getRowNum() >= 2 && !checker) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            worker.setTitle(cell.getStringCellValue());
                            break;
                        case 1:
                            worker.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            worker.setSurname(cell.getStringCellValue());
                            workers.add(worker);
                            break;
                        case 3:
                            workerInSubject.setWorker(worker);
                            workerInSubject.setSubject(subject);
                            workerInSubject.setHours(cell.getStringCellValue());
                            workerInSubjects.add(workerInSubject);
                            break;
                        default:
                            break;
                    }
                }
            }

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
