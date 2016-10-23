package com.reservation.hotel.registration;

import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelType;

public interface ICalculateBestPriceHotel {
	
	void bestPrice();
	
	HotelType calMinPriceHotel();
	
	int individualHotelPrice(HotelType hotelType);
	
	int dayCostCalculation(HotelType hotelType, DayType currentDayType);
	
}
