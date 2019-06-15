package BusReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemCreatorTest {

	 ItemCreator test = new ItemCreator();
     
	    @Test
	    void test16() {	
	        test.createUser("esma");
	        assertEquals("this user exist!", test.createUser("esma"));
}
	    
	    @Test   
	    void test17() {
	        assertEquals("added", test.createUser("ali"));
}
	   
	    
}