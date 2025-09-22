package com.nueuda.miniride.service;

import com.nueuda.miniride.models.Driver;
import com.nueuda.miniride.models.Ride;
import com.nueuda.miniride.models.Rider;

import java.util.ArrayList;
import java.util.List;

public class RideService implements RideBooking{

    private List<Driver> drivers;
    private List<Ride> rides;

    public RideService() {
        drivers = new ArrayList<>();
        rides = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
    @Override
    public void bookRide(Rider rider, Driver driver, String source, String destination) {
        if (driver.isAvailable()) {
            double fare = calculateFare(source, destination);
            Ride ride = new Ride(rider, driver, source, destination, fare);
            rides.add(ride);
            driver.setAvailable(false); // Driver becomes unavailable
            System.out.println("Ride booked successfully: " + ride);
        } else {
            System.out.println("Driver not available.");
        }
    }
    private double calculateFare(String source, String destination) {
        // Simple dummy fare calculation
        return 50 + (Math.random() * 100);
    }

    public void showAvailableDrivers() {
        System.out.println("\nAvailable Drivers:");
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                System.out.println(d);
            }
        }
    }

    public void completeRide(Driver driver) {
        driver.setAvailable(true);
        System.out.println("Ride completed by " + driver.getName() + ", driver is now available again.");
    }
}
