package com.reservation.hotel.model;

import com.reservation.hotel.registration.OrderInput;

public interface IOrderFormatter {

    void inputFormatter(String input, OrderInput orderInput);

    void outputFormatter(HotelType leastPriceHotel);

}
