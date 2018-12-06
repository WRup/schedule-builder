package com.builder.schedule.demo.excel;

import com.builder.schedule.demo.model.Group;
import com.builder.schedule.demo.model.Lecture;
import com.builder.schedule.demo.model.Subject;
import com.builder.schedule.demo.model.Worker;
import com.builder.schedule.demo.model.WorkerInSubject;
import com.builder.schedule.demo.model.Year;
import com.builder.schedule.demo.model.repository.GroupRepository;
import com.builder.schedule.demo.model.repository.LectureRepository;
import com.builder.schedule.demo.model.repository.SubjectRepository;
import com.builder.schedule.demo.model.repository.WorkerInSubjectRepository;
import com.builder.schedule.demo.model.repository.WorkerRepository;
import com.builder.schedule.demo.model.repository.YearRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoaderImpl implements DataLoaderService {

    private final GroupRepository groupRepository;
    private final YearRepository yearRepository;
    private final WorkerRepository workerRepository;
    private final SubjectRepository subjectRepository;
    private final LectureRepository lectureRepository;
    private final WorkerInSubjectRepository workerInSubjectRepository;

    public DataLoaderImpl(GroupRepository groupRepository, YearRepository yearRepository, WorkerRepository workerRepository, SubjectRepository subjectRepository, LectureRepository lectureRepository, WorkerInSubjectRepository workerInSubjectRepository) {
        this.groupRepository = groupRepository;
        this.yearRepository = yearRepository;
        this.workerRepository = workerRepository;
        this.subjectRepository = subjectRepository;
        this.lectureRepository = lectureRepository;
        this.workerInSubjectRepository = workerInSubjectRepository;
    }

    @Override
    public String dataLoad(String filepath) throws InvalidFormatException {
        String parser = "File has not been parsed.";
        ExcelPOIHelper excelPOIHelper = new ExcelPOIHelper();
        CsvPOIHelper csvPOIHelper = new CsvPOIHelper();
        List<ArrayList> listList = new ArrayList<>();
        try {
            if(filepath != null) {
                if(filepath.endsWith(".xlsx") || filepath.endsWith(".xls")) {
                    OPCPackage pkg = OPCPackage.open(new File(filepath));
                    try (XSSFWorkbook workbook = new XSSFWorkbook(pkg)) {
                        XSSFSheet sheet = workbook.getSheetAt(0);
                        listList = excelPOIHelper.readExcel(sheet);
                    }
                } else if(filepath.endsWith(".csv")) {
                    listList = csvPOIHelper.readCsv(filepath);
                } else {
                    return ("Wrong file format");
                }
            } else {
                return ("File missing! Please upload an excel or csv file.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!listList.isEmpty()) {
            parser = "File has been parsed successfully!";
            for (int i = 0; i < listList.size(); i++) {
                switch (i) {
                    case 0:
                        for (Object obj : listList.get(0)) {
                            subjectRepository.save((Subject) obj);
                        }
                        break;
                    case 1:
                        for (Object obj : listList.get(1)) {
                            Worker wrk = (Worker) obj;
                            if(workerRepository.findByNameAndSurname(wrk.getName(), wrk.getSurname()) == null) {
                                workerRepository.save(wrk);
                            }
                        }
                        break;
                    case 2:
                        for (Object obj : listList.get(2)) {
                            yearRepository.save((Year) obj);
                        }
                        break;
                    case 3:
                        for (Object obj : listList.get(3)) {
                            groupRepository.save((Group) obj);
                        }
                        break;
                    case 4:
                        for (Object obj : listList.get(4)) {
                            WorkerInSubject wis = (WorkerInSubject) obj;
                            wis.setWorker(workerRepository.findByNameAndSurname(wis.getWorker().getName(),
                                                                                wis.getWorker().getSurname()));
                            workerInSubjectRepository.save(wis);
                        }
                        break;
                    case 5:
                        for (Object obj : listList.get(5)) {
                            lectureRepository.save((Lecture) obj);
                        }
                }
            }
        }
        return ("File has been uploaded successfully!\n" + parser);
    }
}