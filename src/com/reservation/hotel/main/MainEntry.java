package com.reservation.hotel.main;

import java.text.ParseException;

import com.reservation.hotel.model.CustomerType;
import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelRates;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.registration.OrderInput;
import com.reservation.hotel.registration.Registration;

public class MainEntry {

public static void main(String[] args) throws ParseException {
	
	OrderInput orderInput = new OrderInput();
	roomRates(orderInput);
	Registration registration = new Registration();
	String input= "REWARD:16/05/2016,17/05/2016";
	registration.calculatePrice(input, orderInput);
}

private static void roomRates(OrderInput orderInput) {
	HotelRates lakewoodRegularWeekday = new HotelRates();
	lakewoodRegularWeekday.setPrice(110);
	orderInput.roomRates(HotelType.LAKEWOOD, CustomerType.REGULAR, DayType.WEEKDAY, lakewoodRegularWeekday);
	
	HotelRates lakewoodRegularWeekend = new HotelRates();
	lakewoodRegularWeekend.setPrice(90);
	orderInput.roomRates(HotelType.LAKEWOOD, CustomerType.REGULAR, DayType.WEEKEND, lakewoodRegularWeekend);
	
	HotelRates lakewoodRewardWeekday = new HotelRates();
	lakewoodRewardWeekday.setPrice(80);
	orderInput.roomRates(HotelType.LAKEWOOD, CustomerType.REWARD, DayType.WEEKDAY, lakewoodRewardWeekday);

	HotelRates lakewoodRewardWeekend = new HotelRates();
	lakewoodRewardWeekend.setPrice(80);
	orderInput.roomRates(HotelType.LAKEWOOD, CustomerType.REWARD, DayType.WEEKEND, lakewoodRewardWeekend);
	
	HotelRates bridgewoodRegularWeekday = new HotelRates();
	bridgewoodRegularWeekday.setPrice(160);
	orderInput.roomRates(HotelType.BRIDGEWOOD, CustomerType.REGULAR, DayType.WEEKDAY, bridgewoodRegularWeekday);

	HotelRates bridgewoodRegularWeekend = new HotelRates();
	bridgewoodRegularWeekend.setPrice(60);
	orderInput.roomRates(HotelType.BRIDGEWOOD, CustomerType.REGULAR, DayType.WEEKEND, bridgewoodRegularWeekend);

	HotelRates bridgewoodRewardWeekday = new HotelRates();
	bridgewoodRewardWeekday.setPrice(110);
	orderInput.roomRates(HotelType.BRIDGEWOOD, CustomerType.REWARD, DayType.WEEKDAY, bridgewoodRewardWeekday);

	HotelRates bridgewoodRewardWeekend = new HotelRates();
	bridgewoodRewardWeekend.setPrice(50);
	orderInput.roomRates(HotelType.BRIDGEWOOD, CustomerType.REWARD, DayType.WEEKEND, bridgewoodRewardWeekend);

	HotelRates ridgewoodRegularWeekday = new HotelRates();
	ridgewoodRegularWeekday.setPrice(220);
	orderInput.roomRates(HotelType.RIDGEWOOD, CustomerType.REGULAR, DayType.WEEKDAY, ridgewoodRegularWeekday);

	HotelRates ridgewoodRegularWeekend = new HotelRates();
	ridgewoodRegularWeekend.setPrice(150);
	orderInput.roomRates(HotelType.RIDGEWOOD, CustomerType.REGULAR, DayType.WEEKEND, ridgewoodRegularWeekend);

	HotelRates ridgewoodRewardWeekday = new HotelRates();
	ridgewoodRewardWeekday.setPrice(100);
	orderInput.roomRates(HotelType.RIDGEWOOD, CustomerType.REWARD, DayType.WEEKDAY, ridgewoodRewardWeekday);

	HotelRates ridgewoodRewardWeekend = new HotelRates();
	ridgewoodRewardWeekend.setPrice(40);
	orderInput.roomRates(HotelType.RIDGEWOOD, CustomerType.REWARD, DayType.WEEKEND, ridgewoodRewardWeekend);
	
}		
	
}
