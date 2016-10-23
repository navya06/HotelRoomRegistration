package com.reservation.hotel.registration;

import java.text.ParseException;

import com.reservation.hotel.model.OrderFormatter;

public class Registration {
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public void calculatePrice(String input) throws ParseException{
	OrderFormatter orderFormatter = new OrderFormatter();
	orderFormatter.inputFormatter(input);
	CalculateBestPriceHotel calculateBestPriceHotel = new CalculateBestPriceHotel();
	calculateBestPriceHotel.bestPrice();
	}
}
