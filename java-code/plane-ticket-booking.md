# Assignment: Plane Ticket booking System

You work for a travel startup building a tiny booking module that stores plane tickets and provides basic operations like adding tickets, listing them, and sorting by price. The system must also validate that a ticket's arrival time is not before its departure time.

1. Create a PlaneTicket class with fields: bookingRef (String), price (double), departureTime (java.time.LocalDateTime), arrivalTime (java.time.LocalDateTime).

2. All fields should be private. Prefer immutability (use final where appropriate).

3. The constructor must throw IllegalArgumentException if arrivalTime is before departureTime.

4. Define an interface BookingServiceInterface with the following methods:

    - void addTicket(PlaneTicket ticket)

    - List<PlaneTicket> getAllPlaneTickets()

    - void sortBookings() // sorts tickets by price ascending

5. Implement BookingService that implements BookingServiceInterface and internally uses a List<PlaneTicket> to store tickets.

6. Sorting behavior: sortBookings() must order tickets by price from lowest to highest.

7. Unit tests with JUnit 5 verifying the behaviors below.

8. Cretae Test Cases metioned below:

    - create test file: BookingServiceTest
    - testSortBookingsByPrice()
    - testAddAndRetrieveTickets()

    - create one more test file: PlaneTicketTest
    - testArrivalBeforeDepartureThrowsException
    - testValidTicketDoesNotThrow

### One Reference test Case
```java
@Test
public void testSortBookingsByPrice() {
BookingService bookingService = new BookingService();

// Tickets with different booking refs and prices
PlaneTicket t1 = new PlaneTicket("REF123", 500.0,
LocalDateTime.of(2025,9,16,10,0), LocalDateTime.of(2025,9,16,12,0));
PlaneTicket t2 = new PlaneTicket("REF456", 300.0,
LocalDateTime.of(2025,9,16,11,0), LocalDateTime.of(2025,9,16,13,0));
PlaneTicket t3 = new PlaneTicket("REF789", 700.0,
LocalDateTime.of(2025,9,16,9,0), LocalDateTime.of(2025,9,16,11,0));

bookingService.addTicket(t1);
bookingService.addTicket(t2);
bookingService.addTicket(t3);

bookingService.sortBookings();

List<PlaneTicket> sorted = bookingService.getAllPlaneTickets();

assertEquals("REF456", sorted.get(0).getBookingRef());
assertEquals("REF123", sorted.get(1).getBookingRef());
assertEquals("REF789", sorted.get(2).getBookingRef());
}
```