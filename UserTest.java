package BusReservation;
import org.junit.jupiter.api.Test;

import BusReservation.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();

    @Test
    void getUsername14() {
        user.setUsername("Onur");
        assertEquals("Onur", user.getUsername());
        assertNotEquals("Esma", user.getUsername());
    }

    @Test
    void display15() {
        user.setUsername("Onur");
        assertEquals("Onur", user.display());
        assertNotEquals("Esma", user.display());
    }
}