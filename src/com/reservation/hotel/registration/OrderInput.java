package com.reservation.hotel.registration;

import java.util.HashMap;
import java.util.Map;

import com.reservation.hotel.model.CustomerType;
import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelRates;
import com.reservation.hotel.model.HotelType;


public class OrderInput implements IOrderInput {
    private static UserProfile userProfile;
    public class UserProfile {
        private CustomerType currentCustomerType;
        private Map<String, String> listDates;
        private String[] stayDates;

        public CustomerType getCustomerType() {
            return currentCustomerType;
        }

        public void setCustomerType(CustomerType customerType) {
            this.currentCustomerType = customerType;
        }

        public Map<String, String> getListDates() {
            return listDates;
        }

        public void setListDates(Map<String, String> listDates) {
            this.listDates = listDates;
        }

        public void setStayDates(String[] stayDates) { this.stayDates=stayDates; }

        public String[] getStayDates() { return stayDates; }
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    Map<HotelType, Map<CustomerType, Map<DayType, Integer>>> prices = new HashMap<>();
    Map<DayType, Integer> dayRate = new HashMap<>();
    Map<CustomerType, Map<DayType, Integer>> hotelRate = new HashMap<>();

    public void roomRates(HotelType hotelType, CustomerType customerType, DayType dayType, HotelRates hotelRates) {

        if (prices == null) {
            dayRate.put(dayType, hotelRates.price);
            hotelRate.put(customerType, dayRate);
            prices.put(hotelType, hotelRate);
        } else {
            if (prices.containsKey(hotelType)) {
                hotelRate = prices.get(hotelType);
                if (hotelRate.containsKey(customerType)) {
                    dayRate = hotelRate.get(customerType);
                    dayRate.put(dayType, hotelRates.price);
                } else {
                    Map<DayType, Integer> dayRate = new HashMap<>();
                    dayRate.put(dayType, hotelRates.price);
                    hotelRate.put(customerType, dayRate);
                }
            } else {
                Map<DayType, Integer> dayRate = new HashMap<>();
                Map<CustomerType, Map<DayType, Integer>> hotelRate = new HashMap<>();
                dayRate.put(dayType, hotelRates.price);
                hotelRate.put(customerType, dayRate);
                prices.put(hotelType, hotelRate);
            }
        }

    }

    public Integer dayCostCalculation(HotelType hotelType, CustomerType customerType, DayType currentDayType) {
        Map<CustomerType, Map<DayType, Integer>> hotel = prices.get(hotelType);
        Map<DayType, Integer> currentCustomerType = hotel.get(customerType);
        Integer hotelRate = currentCustomerType.get(currentDayType);
        return hotelRate;
    }

    public Map<HotelType, Map<CustomerType, Map<DayType, Integer>>> getPrices() {
        return prices;
    }

}
