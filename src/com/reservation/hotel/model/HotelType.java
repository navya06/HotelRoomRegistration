package com.reservation.hotel.model;

public enum HotelType {
    LAKEWOOD(3),
    BRIDGEWOOD(4),
    RIDGEWOOD(5);

    int rating;

    HotelType(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}