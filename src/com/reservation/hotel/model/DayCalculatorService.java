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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String dates : stayDates) {

            Date date = simpleDateFormat.parse(dates);
            DateFormat dateFormat = new SimpleDateFormat("EEEE");
            String finalDay = dateFormat.format(date);
            listDates.put(dates, finalDay);
        }
        return listDates;
    }

}
