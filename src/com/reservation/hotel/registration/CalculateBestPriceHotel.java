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
    OrderFormatter orderFormatter = new OrderFormatter();
    OrderInput orderInput;
    int individualHotelPrice = 0;

    public void bestPrice(OrderInput orderInput) {
        this.orderInput = orderInput;
        OrderInput.UserProfile userProfile = orderInput.getUserProfile();
        currentCustomerType = userProfile.getCustomerType();
        listDate = userProfile.getListDates();
        stayDates = userProfile.getStayDates();
        prices = orderInput.getPrices();
        for (HotelType hotelType : HotelType.values()) {
            individualHotelPrice = individualHotelPrice(hotelType);
            totalIndividualPrice.put(hotelType, individualHotelPrice);
        }
        HotelType bestHotel= calculateMinimumPriceHotel().getKey();
        orderFormatter.outputFormatter(bestHotel);
    }

    public int individualHotelPrice(HotelType hotelType) {
        int totalHotelPrice = 0;
        for (Map.Entry<String,String> entry : listDate.entrySet()) {
            String day = entry.getValue();
            boolean isAWeekday = (day.equals("Monday") || day.equals("TUESDAY") || day.equals("WEDNESDAY") || day.equals("THRUSDAY") || day.equals("FRIDAY"));
            if (isAWeekday) {
                totalHotelPrice += orderInput.dayCostCalculation(hotelType, currentCustomerType, DayType.WEEKDAY);
            } else {
                totalHotelPrice += orderInput.dayCostCalculation(hotelType, currentCustomerType, DayType.WEEKEND);
            }
        }
        return totalHotelPrice;
    }

    public Map.Entry<HotelType, Integer> calculateMinimumPriceHotel() {
        Map.Entry<HotelType, Integer> minimumEntry = null;
        for (Entry<HotelType, Integer> entry : totalIndividualPrice.entrySet())
            if (minimumEntry==null || minimumEntry.getValue() > entry.getValue()) {
                minimumEntry = changeBestHotel(minimumEntry, entry);
            } else {
                boolean HasSameValues = minimumEntry.getValue() == entry.getValue();
                if (HasSameValues) {
                    minimumEntry=calculateBestRatedHotel(minimumEntry, entry);
                    }
                }
        return minimumEntry;
    }

    private Map.Entry<HotelType, Integer> calculateBestRatedHotel(Map.Entry<HotelType, Integer> minimumEntry, Entry<HotelType, Integer> entry) {

        int currentHotelRating = minimumEntry.getKey().getRating();
        int competitorHotelRating = entry.getKey().getRating();
        boolean isTheRatingHigh= (currentHotelRating < competitorHotelRating);
        if (isTheRatingHigh) {
            minimumEntry= changeBestHotel(minimumEntry, entry);
        }
        return minimumEntry;
    }

    private Map.Entry<HotelType, Integer> changeBestHotel(Map.Entry<HotelType, Integer> minimumEntry, Entry<HotelType, Integer> entry) {
        minimumEntry= entry;
        return minimumEntry;
    }

}