package com.reservation.hotel.registration;

import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.model.OrderFormatter;

public interface ICalculateBestPriceHotel {

    void bestPrice(OrderFormatter orderFormatter, OrderInput orderInput);

    HotelType calculateMinimumPriceHotel();

    int individualHotelPrice(HotelType hotelType);

}
