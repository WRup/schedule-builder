package com.builder.schedule.demo.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface DataLoaderService {

    void dataLoad(String filepath) throws FileNotFoundException, IOException, InvalidFormatException;

}