package com.reservation.hotel.registration;

import java.util.HashMap;
import java.util.Map;

import com.reservation.hotel.model.CustomerType;
import com.reservation.hotel.model.DayType;
import com.reservation.hotel.model.HotelRates;
import com.reservation.hotel.model.HotelType;
import com.reservation.hotel.registration.OrderInput.UserProfile;

public class OrderInput {
	private static UserProfile userProfile;
	public class UserProfile{
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
		

	}
	
	public void setUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		this.userProfile = userProfile;
	}
	
	Map<HotelType, Map<CustomerType, Map<DayType, HotelRates>>> prices = new HashMap<>();
	Map<CustomerType, Map<DayType, HotelRates>> hotelRate = new HashMap<>();
	
	public void roomRates(HotelType hotelType, CustomerType customerType, DayType dayType, HotelRates hotelRates){
		Map<DayType, HotelRates> dayRate = new HashMap<>();
		
		dayRate.put(dayType, hotelRates);
		hotelRate.put(customerType, dayRate);
		prices.put(hotelType, hotelRate);
	}
	
	public Map<HotelType, Map<CustomerType, Map<DayType, HotelRates>>> getCurrentPrices(){
		return prices;
	}
	
}
