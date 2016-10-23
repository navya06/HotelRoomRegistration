package com.reservation.hotel.model;

public enum DayType {
    WEEKDAY,
    WEEKEND;

    public static DayType getType(String type) {
        return DayType.valueOf(type);
    }
}
