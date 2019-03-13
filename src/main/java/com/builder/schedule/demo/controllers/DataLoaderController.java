package com.builder.schedule.demo.controllers;


import com.builder.schedule.demo.excel.DataLoaderService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

    private final DataLoaderService dataLoaderService;

    public DataLoaderController(DataLoaderService dataLoaderService) {
        this.dataLoaderService = dataLoaderService;
    }

    @GetMapping("/upload")
    public String index() {
        return "admin/uploadFile";
    }

    @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) throws IOException, InvalidFormatException {
        String message;
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
        try (FileOutputStream f = new FileOutputStream(fileLocation)) {
            int ch;
            while ((ch = in.read()) != -1) {
                f.write(ch);
            }
            f.flush();
        } catch (Exception e) {
            message = "File cannot be loaded.";
            model.addAttribute("message", message);
            return "admin/fileUploaded";
        }
        message = dataLoaderService.dataLoad(fileLocation);
        model.addAttribute("message", message);
        return "admin/fileUploaded";
    }
}