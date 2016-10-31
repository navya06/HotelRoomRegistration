package com.reservation.hotel.registration;

import java.util.Map;

import com.reservation.hotel.model.CustomerType;
import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelRates;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.registration.OrderInput.UserProfile;

public interface IOrderInput {

    void setUserProfile(UserProfile userProfile);

    void roomRates(HotelType hotelType, CustomerType customerType, DayType dayType, HotelRates hotelRates);

    Map<HotelType, Map<CustomerType, Map<DayType, Integer>>> getPrices();

    Integer dayCostCalculation(HotelType hotelType, CustomerType customerType, DayType currentDayType);

}
