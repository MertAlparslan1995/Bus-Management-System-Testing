package BusReservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class BusReservationtest
{
  public BusReservationtest() {}
  
  BusReservation travel = new BusReservation();
  
  @org.junit.Before
  public void setUp() throws Exception {
    travel.setCurrentCity("izmir");
    BusReservation.setRegularSeat(9);
    BusReservation.setSingleSeat(5);
    travel.setDestinationCity("istanbul");
  }
  
  @Test
  public void testCity1() {
    org.junit.Assert.assertEquals("izmir", travel.getCurrentCity());
  }
  @Test
  public void testCity2() {
    org.junit.Assert.assertEquals("ankara", travel.getCurrentCity());
  }
  
  @Test
  public void testCity3() { 
	org.junit.Assert.assertEquals("istanbul", travel.getDestinationCity()); }
  
  @Test
  public void testCity4() { 
	org.junit.Assert.assertEquals("aydýn", travel.getDestinationCity()); }
  
  @Test
  public void testCity5() {
    org.junit.Assert.assertEquals("van", travel.getCurrentCity());
  }
  
  @Test
  public void testRegularSeat6()
  {
    BusReservation.setRegularSeat(9);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkRegularSeatNumber(9)));
  }
  
  @Test
  public void testRegularSeat7() {
    BusReservation.setRegularSeat(6);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkRegularSeatNumber(6)));
  }
  
  @Test
  public void testRegularSeat8() {
    BusReservation.setRegularSeat(-1);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkRegularSeatNumber(-1)));
  }
  
  @Test
  public void testRegularSeat9() {
    BusReservation.setRegularSeat(0);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkRegularSeatNumber(0)));
  }
 
  
  @Test
  public void testSingleSeat10()
  {
    BusReservation.setSingleSeat(9);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkSingleSeatNumber(9)));
  }
  
  @Test
  public void testSingleSeat11() {
    BusReservation.setSingleSeat(6);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkSingleSeatNumber(6)));
  }
  
  @Test
  public void testSingleSeat12() {
    BusReservation.setSingleSeat(-1);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkSingleSeatNumber(-1)));
  }
  
  @Test
  public void testSingleSeat13() {
    BusReservation.setSingleSeat(0);
    org.junit.Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(BusReservation.checkSingleSeatNumber(0)));
  }
  
 
 
}

