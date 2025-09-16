package com.nueuda.miniride.service;

import com.nueuda.miniride.models.Driver;
import com.nueuda.miniride.models.Rider;

public interface RideBooking {
    void bookRide(Rider rider, Driver driver, String source, String destination);
}
