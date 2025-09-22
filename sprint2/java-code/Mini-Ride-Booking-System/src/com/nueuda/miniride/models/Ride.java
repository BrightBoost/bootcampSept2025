package com.nueuda.miniride.models;

public class Ride {
    private Rider rider;
    private Driver driver;
    private String source;
    private String destination;
    private double fare;

    public Ride(Rider rider, Driver driver, String source, String destination, double fare) {
        this.rider = rider;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public double getFare() { return fare; }

    @Override
    public String toString() {
        return "Ride from " + source + " to " + destination +
               " | Rider: " + rider.getName() +
               " | Driver: " + driver.getName() +
               " | Fare: ₹" + fare;
    }
}
