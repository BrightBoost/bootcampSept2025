package com.neueda.airlines;

import com.neueda.airlines.models.PlaneTicket;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class PlaneTicketTest {

    @Test
    public void testArrivalBeforeDepartureThrowsException() {
        LocalDateTime departure = LocalDateTime.of(2025, 9, 16, 10, 0);
        LocalDateTime arrival = LocalDateTime.of(2025, 9, 16, 9, 0); // before departure

        assertThrows(IllegalArgumentException.class, () -> {
            new PlaneTicket("REF001", 400.0, departure, arrival);
        });
    }

    @Test
    public void testValidTicketDoesNotThrow() {
        LocalDateTime departure = LocalDateTime.of(2025, 9, 16, 10, 0);
        LocalDateTime arrival = LocalDateTime.of(2025, 9, 16, 12, 0);


// Should not throw — constructing is enough for the test
        new PlaneTicket("REF002", 500.0, departure, arrival);
    }
}