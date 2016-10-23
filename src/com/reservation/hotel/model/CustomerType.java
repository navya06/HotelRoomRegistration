package com.reservation.hotel.model;

public enum CustomerType {

    REGULAR, REWARD;

    public static CustomerType getType(String type) {
        return CustomerType.valueOf(type);

    }
}
