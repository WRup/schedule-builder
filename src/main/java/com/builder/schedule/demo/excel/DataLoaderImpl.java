package com.builder.schedule.demo.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class DataLoaderImpl implements DataLoaderService {

    @Override
    public void init() {
        //todo
    }

    @Override
    public void store(MultipartFile file) {
        //todo
    }

    @Override
    public Stream<Path> loadAll() {
        //todo
        return null;
    }

    @Override
    public Path load(String filename) {
        ExcelPOIHelper excelPOIHelper = new ExcelPOIHelper();
        List<ArrayList> listList = new ArrayList<>();
        try (OPCPackage pkg = OPCPackage.open(new File(filename))) {


            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            XSSFSheet sheet = workbook.getSheetAt(0);
            listList = excelPOIHelper.readExcel(sheet);

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        //todo
        return null;
    }

    @Override
    public void deleteAll() {
        //todo
    }
}