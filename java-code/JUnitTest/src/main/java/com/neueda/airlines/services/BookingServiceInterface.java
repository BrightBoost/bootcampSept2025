package com.neueda.airlines.services;

import com.neueda.airlines.models.PlaneTicket;

import java.util.List;


public interface BookingServiceInterface {
    void addTicket(PlaneTicket ticket);
    List<PlaneTicket> getAllPlaneTickets();
    void sortBookings();
}