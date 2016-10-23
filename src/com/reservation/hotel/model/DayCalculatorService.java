package com.reservation.hotel.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DayCalculatorService {

    public Map<String, String> dayCalculator(String[] stayDates) throws ParseException {
        // TODO Auto-generated method stub
        Map<String, String> listDates = new HashMap<>();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        for (String dates : stayDates) {

            Date dt1 = format1.parse(dates);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            String finalDay = format2.format(dt1);
            listDates.put(dates, finalDay);
        }
        return listDates;
    }

}
