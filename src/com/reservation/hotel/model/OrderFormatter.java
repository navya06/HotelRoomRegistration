package com.reservation.hotel.model;

import java.text.ParseException;
import java.util.Map;

import com.reservation.hotel.registration.OrderInput;
import com.reservation.hotel.registration.OrderInput.UserProfile;

public class OrderFormatter implements IOrderFormatter {

    public String[] stayDates;
    OrderInput orderInput;
    public void inputFormatter(String input, OrderInput orderInput) {
        String[] inputs = input.split(":");
        this.orderInput = orderInput;
        OrderInput.UserProfile userProfile = orderInput.new UserProfile();
        int i = 0;
        userProfile.setCustomerType(CustomerType.getType(inputs[i++]));
        stayDates = inputs[i].split(",");
        for (String string : stayDates) {
            System.out.println(string);
        }
        DayCalculatorService DCS = new DayCalculatorService();
        try {
            userProfile.setListDates(DCS.dayCalculator(stayDates));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.orderInput.setUserProfile(userProfile);
    }
    public void outputFormatter(HotelType minimumPriceHotel) {
        System.out.println(minimumPriceHotel);
    }
    public String[] getStayDates() { return stayDates; }
}
