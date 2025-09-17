package com.neueda.airlines.services;

import com.neueda.airlines.models.PlaneTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class BookingService implements BookingServiceInterface {
    private final List<PlaneTicket> tickets = new ArrayList<>();


    @Override
    public void addTicket(PlaneTicket ticket) {
        tickets.add(ticket);
    }


    @Override
    public List<PlaneTicket> getAllPlaneTickets() {
        return new ArrayList<>(tickets);
    }


    @Override
    public void sortBookings() {
        Collections.sort(tickets, Comparator.comparingDouble(PlaneTicket::getPrice));
    }
}