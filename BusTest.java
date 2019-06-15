package BusReservation;
import org.junit.jupiter.api.Test;

import BusReservation.Bus;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    Bus bus = new Bus();

    @Test
    void getCapacity() {
        bus.setCapacity(30);
        
        assertEquals(30, bus.getCapacity());
       
    }

    @Test
    void setPlate() {
        bus.setPlate("35AB35");
        assertEquals("35AB35", bus.getPlate());
        
    }

    @Test
    void setId() {
        bus.setId(10);
        assertEquals(10, bus.getId());
    }

    @Test
    void display() {
        bus.setId(1);
        bus.setPlate("35AB35");
        bus.setCapacity(10);
        bus.setStart("Izmir");
        bus.setEnd("Istanbul");
        assertEquals("1\t\t35AB35\t\t10\t\tIzmir\t\tIstanbul", bus.display());
        assertNotEquals("135AB3510IzmirIstanbul", bus.display());
    }
}