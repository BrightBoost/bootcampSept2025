package com.nueuda.miniride;

import com.nueuda.miniride.models.Driver;
import com.nueuda.miniride.models.Rider;
import com.nueuda.miniride.service.RideService;

public class Main {
    public static void main(String[] args) {
        RideService service = new RideService();

        // Add Drivers
        Driver d1 = new Driver("D1", "John", "Car - Swift");
        Driver d2 = new Driver("D2", "Mike", "Bike - Pulsar");
        service.addDriver(d1);
        service.addDriver(d2);

        // Add Riders
        Rider r1 = new Rider("R1", "Alice");
        Rider r2 = new Rider("R2", "Bob");

        // Show available drivers
        service.showAvailableDrivers();

        // Book rides
        service.bookRide(r1, d1, "Park Street", "Airport");
        service.bookRide(r2, d1, "Station", "Mall"); // Should fail (d1 busy)
        service.bookRide(r2, d2, "Station", "Mall");

        // Complete ride and free driver
        service.completeRide(d1);

        service.showAvailableDrivers();
    }
}
