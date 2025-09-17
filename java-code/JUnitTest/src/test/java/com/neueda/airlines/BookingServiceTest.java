package com.neueda.airlines;

import com.neueda.airlines.models.PlaneTicket;
import com.neueda.airlines.services.BookingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {

    @Test
    public void testSortBookingsByPrice() {
        BookingService bookingService = new BookingService();

        PlaneTicket t1 = new PlaneTicket("REF123", 500.0,
                LocalDateTime.of(2025, 9, 16, 10, 0), LocalDateTime.of(2025, 9, 16, 12, 0));
        PlaneTicket t2 = new PlaneTicket("REF456", 300.0,
                LocalDateTime.of(2025, 9, 16, 11, 0), LocalDateTime.of(2025, 9, 16, 13, 0));
        PlaneTicket t3 = new PlaneTicket("REF789", 700.0,
                LocalDateTime.of(2025, 9, 16, 9, 0), LocalDateTime.of(2025, 9, 16, 11, 0));


        bookingService.addTicket(t1);
        bookingService.addTicket(t2);
        bookingService.addTicket(t3);

        bookingService.sortBookings();

        List<PlaneTicket> sorted = bookingService.getAllPlaneTickets();

        assertEquals("REF456", sorted.get(0).getBookingRef());
        assertEquals("REF123", sorted.get(1).getBookingRef());
        assertEquals("REF789", sorted.get(2).getBookingRef());
    }


    @Test
    public void testAddAndRetrieveTickets() {
        BookingService bookingService = new BookingService();

        PlaneTicket t1 = new PlaneTicket("A1", 100.0,
                LocalDateTime.of(2025, 9, 16, 10, 0), LocalDateTime.of(2025, 9, 16, 12, 0));

        bookingService.addTicket(t1);
        List<PlaneTicket> list = bookingService.getAllPlaneTickets();
        assertEquals(1, list.size());
        assertEquals("A1", list.get(0).getBookingRef());
    }
}