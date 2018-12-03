package com.builder.schedule.demo.excel;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.Year;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelPOIHelper {

    public List<ArrayList> readExcel(XSSFSheet sheet) throws IOException {

        List<ArrayList> lists = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<Year> years = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();
        Subject subject = new Subject();
        Worker worker = new Worker();
        Year year = new Year();
        Group group = new Group();

        for (Row row : sheet) {
            if(row.getRowNum() == 0) {
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        subject.setName(cell.getStringCellValue());
                        break;
                    case 1:
                        subject.setType(cell.getStringCellValue());
                        subjects.add(subject);
                        break;
                    case 2:
                        worker.setName(cell.getStringCellValue());
                        break;
                    case 3:
                        worker.setSurname(cell.getStringCellValue());
                        workers.add(worker);
                        break;
                    case 4:
                        year.setName(cell.getStringCellValue());
                        break;
                    case 5:
                        year.setNumberOfGroups(cell.getStringCellValue());
                        break;
                    case 6:
                        year.setTerm(cell.getStringCellValue());
                        break;
                    case 7:
                        year.setStudents(cell.getStringCellValue());
                        years.add(year);
                        break;
                }
            }
            for (int i = 1; i <= Integer.valueOf(year.getNumberOfGroups()); i++) {
                group.setName(String.valueOf(i));
                group.setType(subject.getType());
                group.setYear(year);
                groups.add(group);
            }

        }
        lists.add(subjects);
        lists.add(workers);
        lists.add(years);
        lists.add(groups);


        return lists;
    }

}
