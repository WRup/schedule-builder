package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.excel.DataLoaderService;
import com.builder.schedule.demo.excel.ExcelPOIHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return "excel";
    }

    @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) throws IOException, InvalidFormatException {
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
        dataLoaderService.dataLoad(fileLocation);
        model.addAttribute("message", "File: " + file.getOriginalFilename() + " has been uploaded successfully!");
        return "excel";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readPOI")
    public String readPOI(Model model) {

        if(fileLocation != null) {
            if(fileLocation.endsWith(".xlsx") || fileLocation.endsWith(".xls")) {
                model.addAttribute("data", fileLocation);
            } else {
                model.addAttribute("message", "Not a valid excel file!");
            }
        } else {
            model.addAttribute("message", "File missing! Please upload an excel file.");
        }
        return "excel";
    }
}