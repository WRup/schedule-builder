package com.builder.schedule.demo.common;


import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DateConverter {


    public Date convertDate(String date) throws ParseException {
        date = date.replaceAll("^\"|\"$", "");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSX");
        return dateFormat.parse(date);
    }
}
