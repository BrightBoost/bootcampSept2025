package com.neueda.airlines.models;

import java.time.LocalDateTime;

public class PlaneTicket {
    private final String bookingRef;
    private final double price;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;


    public PlaneTicket(String bookingRef, double price,
                       LocalDateTime departureTime, LocalDateTime arrivalTime) {
        if (arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Arrival time cannot be before departure time.");
        }
        this.bookingRef = bookingRef;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public String getBookingRef() {
        return bookingRef;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }


    @Override
    public String toString() {
        return "PlaneTicket{" +
                "bookingRef='" + bookingRef + '\'' +
                ", price=" + price +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}