package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.excel.DataLoaderService;
import com.builder.schedule.demo.excel.ExcelPOIHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class DataLoaderController {

    private String fileLocation;
    private ExcelPOIHelper excelPOIHelper;
    @Autowired
    private DataLoaderService dataLoaderService;

    @GetMapping("")
    public String index() {
        return "loader/excel";
    }

    @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) throws IOException, InvalidFormatException, InterruptedException {
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        excelPOIHelper = new ExcelPOIHelper();
        fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
        try (FileOutputStream f = new FileOutputStream(fileLocation)) {
            int ch = 0;
            while ((ch = in.read()) != -1) {
                f.write(ch);
            }
            f.flush();
        } catch (Exception e) {
            System.out.print("File cannot be loaded.");
        }
        String message = dataLoaderService.dataLoad(fileLocation);
        System.out.println(message);
        model.addAttribute("message", message);
        return "loader/excel";
    }
}