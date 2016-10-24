package com.reservation.hotel.registration;

import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.model.OrderFormatter;

public interface ICalculateBestPriceHotel {
	
	void bestPrice(OrderFormatter orderFormatter, OrderInput orderInput);
	
	HotelType calMinPriceHotel();
	
	int individualHotelPrice(HotelType hotelType);
	
	int dayCostCalculation(HotelType hotelType, DayType currentDayType);
	
}
