package com.reservation.hotel.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.reservation.hotel.model.CustomerType;
import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelRates;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.model.OrderFormatter;

public class CalculateBestPriceHotel implements ICalculateBestPriceHotel{
	
	private CustomerType currentCustomerType;
	Map<String, String> listDate = new HashMap<>();
	String[] stayDates;
	
	Map<HotelType, Map<CustomerType, Map<DayType, HotelRates>>> prices;
	Map<HotelType, Integer> totalIndividualPrice = new HashMap<>();
	private int currentHotelRating;
	private int competitorHotelRating;
	OrderFormatter orderFormatter;
    OrderInput orderInput;
    int individualHotelPrice=0;
	
	public void bestPrice(OrderFormatter orderFormatter, OrderInput orderInput){
		this.orderFormatter = orderFormatter;
		 this.orderInput =orderInput;
		OrderInput.UserProfile userProfile = orderInput.getUserProfile();
		currentCustomerType = userProfile.getCustomerType();
		listDate = userProfile.getListDates();
		stayDates = this.orderFormatter.getStayDates();
		prices = orderInput.getCurrentPrices();
		for (HotelType hotelType : HotelType.values()) {
            individualHotelPrice=individualHotelPrice(hotelType);
		    totalIndividualPrice.put(hotelType, individualHotelPrice);
		}
		
		
		this.orderFormatter.outputFormatter(calMinPriceHotel());
	}
	public HotelType calMinPriceHotel() {
		HotelType minimumPriceHotel=null;
		int minimumHotelPrice=0;

		for(Entry<HotelType, Integer> entry :totalIndividualPrice.entrySet())
			if (minimumHotelPrice == 0 || minimumHotelPrice > entry.getValue()) {
//		        
				minimumHotelPrice= entry.getValue();
				minimumPriceHotel= entry.getKey();
			}
//		   else{
//				if(((Entry<HotelType, Integer>) min).getValue() == entry.getValue()){	
//	    		HotelType entryHotel = entry.getKey().
//
//	        	competitorHotelRating= entryHotel.getRating();
//			if(currentHotelRating < competitorHotelRating)
//			min = (Map<HotelType, Integer>) entry;
//	        }
//	        
//				}
		    return minimumPriceHotel;
		
	}
	
	public int individualHotelPrice(HotelType hotelType) {
		int totalHotelPrice=0;
		for(String date: stayDates){
			if(listDate.containsKey(date)){
				String day = listDate.get(date);
				if(day.equals("Monday")||day.equals("TUESDAY")||day.equals("WEDNESDAY")||day.equals("THRUSDAY")||day.equals("FRIDAY"))
				{
					DayType currentDayType = DayType.WEEKDAY;
					totalHotelPrice+=dayCostCalculation(hotelType, currentDayType);
				}
				else {
					DayType currentDayType = DayType.WEEKEND;
					totalHotelPrice+=dayCostCalculation(hotelType, currentDayType);
				}
				}
				
			}
		return totalHotelPrice;
		}
	public int dayCostCalculation(HotelType hotelType, DayType currentDayType) {
		Map<CustomerType, Map<DayType, HotelRates>> hotel = prices.get(hotelType);
		Map<DayType, HotelRates> customerType = hotel.get(currentCustomerType);
		HotelRates hotelRates = customerType.get(currentDayType);
		return hotelRates.Price;
	}	
	}

