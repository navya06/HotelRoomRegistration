package com.reservation.hotel.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.reservation.hotel.model.*;

public class CalculateBestPriceHotel implements ICalculateBestPriceHotel {

    private CustomerType currentCustomerType;
    Map<String, String> listDate = new HashMap<>();
    String[] stayDates;

    Map<HotelType, Map<CustomerType, Map<DayType, Integer>>> prices;
    Map<HotelType, Integer> totalIndividualPrice = new HashMap<>();
    OrderFormatter orderFormatter;
    OrderInput orderInput;
    int individualHotelPrice = 0;

    public void bestPrice(OrderFormatter orderFormatter, OrderInput orderInput) {
        this.orderFormatter = orderFormatter;
        this.orderInput = orderInput;
        OrderInput.UserProfile userProfile = orderInput.getUserProfile();
        currentCustomerType = userProfile.getCustomerType();
        listDate = userProfile.getListDates();
        stayDates = this.orderFormatter.getStayDates();
        prices = orderInput.getPrices();
        for (HotelType hotelType : HotelType.values()) {
            individualHotelPrice = individualHotelPrice(hotelType);
            totalIndividualPrice.put(hotelType, individualHotelPrice);
        }
        this.orderFormatter.outputFormatter(calculateMinimumPriceHotel());
    }

    public HotelType calculateMinimumPriceHotel() {
        HotelType minimumPriceHotel = null;
        int minimumHotelPrice = 0;

        for (Entry<HotelType, Integer> entry : totalIndividualPrice.entrySet())
            if (minimumHotelPrice == 0 || minimumHotelPrice > entry.getValue()) {
                minimumHotelPrice = entry.getValue();
                minimumPriceHotel = entry.getKey();
            } else {
                if (minimumHotelPrice == entry.getValue()) {
                    HotelType entryHotel = entry.getKey();
                    int currentHotelRating = minimumPriceHotel.getRating();
                    int competitorHotelRating = entryHotel.getRating();
                    if (currentHotelRating < competitorHotelRating) {
                        minimumHotelPrice = entry.getValue();
                        minimumPriceHotel = entry.getKey();
                    }

                }
            }
        return minimumPriceHotel;
    }

    public int individualHotelPrice(HotelType hotelType) {
        int totalHotelPrice = 0;
        for (String date : stayDates) {
            if (listDate.containsKey(date)) {
                String day = listDate.get(date);
                if (day.equals("Monday") || day.equals("TUESDAY") || day.equals("WEDNESDAY") || day.equals("THRUSDAY") || day.equals("FRIDAY")) {
                    DayType currentDayType = DayType.WEEKDAY;
                    totalHotelPrice += orderInput.dayCostCalculation(hotelType, currentCustomerType, currentDayType);
                } else {
                    DayType currentDayType = DayType.WEEKEND;
                    totalHotelPrice += orderInput.dayCostCalculation(hotelType, currentCustomerType, currentDayType);
                }
            }

        }
        return totalHotelPrice;
    }
}

