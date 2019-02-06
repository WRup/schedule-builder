package com.builder.schedule.demo.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public interface DataLoaderService {

    String dataLoad(String filepath) throws IOException, InvalidFormatException;

    void save(List<ArrayList> list);

}