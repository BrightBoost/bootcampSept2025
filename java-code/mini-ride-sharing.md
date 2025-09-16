# Assignment: Mini Ride-Sharing System

Implement a small ride-sharing system, app must let riders request rides, match them to available drivers, track rides, and complete rides.

## Step By Step Task 

1. Create model classes (to achieve encaptulation)
    - Driver
    - private fields: String id, String name, String vehicle, boolean available
    - constructor, getters, setAvailable(boolean), toString()

    - Rider
    - private fields: String id, String name
    - constructor, getters, toString()

    - Ride
    - private fields: String id (or generate), Rider rider, Driver driver, String source, String destination, double fare, String status (REQUESTED, ONGOING, COMPLETED)
    - constructor, getters/setters, toString()

2. Define an interface (to achieve abstraction)

    - public interface RideBooking { Ride bookRide(Rider rider, String source, String destination); }
    - bookRide returns the Ride object (or null if booking failed).

3. Implement service class using collections

    - public class RideService implements RideBooking
    - Fields: List<Driver> drivers, List<Ride> rides, Map<String, List<Ride>> riderHistory (key = riderId)

4. Methods to implement:

    - void addDriver(Driver d) — add driver to pool
    - Ride bookRide(Rider rider, String source, String destination)
    - calculate fare
    - void showAvailableDrivers()
    - boolean completeRide(String rideId) or boolean completeRide(Ride ride) set ride status to COMPLETED, mark driver available, return true/false
    
    - List<Ride> getRiderHistory(String riderId)  (Extra Task)

5. Fare calculation (simple & deterministic so tests are reproducible)

    - Hint: double fare = 50 + 10 * Math.abs(source.length() - destination.length());

6. Usage (Main)

    - Create 3–4 drivers and 2–3 riders.

    - Show available drivers, book rides (including trying to book when a driver is busy), complete a ride, then show available drivers again.

    - Print out rider history.