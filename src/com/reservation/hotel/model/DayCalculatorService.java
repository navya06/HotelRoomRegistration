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
        Map<String, String> listOfDates = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String currentDate : stayDates) {
            Date date = simpleDateFormat.parse(currentDate);
            DateFormat dateFormat = new SimpleDateFormat("EEEE");
            String finalDay = dateFormat.format(date);
            listOfDates.put(currentDate, finalDay);
        }
        return listOfDates;
    }
}
