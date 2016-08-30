package uq.deco2800.ducktales;
import uq.deco2800.ducktales.world.DuckClock;
import org.junit.Test;
import static org.junit.Assert.*;

public class DuckClockTest {

	/**
	 * firstTest tests getMinute Method
	 * after setting DuckClock to a certain time do checks
	 * to see if that time is the same.
	 */
	@Test
	public void testGetMinute() {
		
		//Instatiate all clocks to be tested against
		DuckClock validClock = new DuckClock(5, 30);
		//DuckClock negativeClockMinute = new DuckClock(0, -10);
		
		//Test for valid minute time variable
		assertTrue("Minute has wrong value", validClock.getMinute() == 30);

		//--- Invalid duckClock instantiation tests ---
		//Test for negative time variables
		
		//Test for out of range top end variables
		
	}
	
	/**
	 * secondTest tests getHour Method
	 * after setting DuckClock to a certain time do checks
	 * to see if that hour is the same at time of launch 
	 */
	@Test
	public void testGetHour() {
		
		//Instatiate all clocks to be tested against
		DuckClock validClock = new DuckClock(5, 30);
		//DuckClock negativeClockHour = new DuckClock(-4, 0);
		//Test for valid time variables
		
		assertTrue("Hour has wrong value", validClock.getHour() == 5);		
		//--- Invalid duckClock instantiation tests ---
		//Test for negative time variables
			
		//Test for out of range top end variables
	}

	/**
	 * thirdTest tests setHour Method
	 * after setting DuckClock to a certain time do checks
	 * to see if after updating the clock using setHour Method
	 * that that clock's Hour becomes what it was set to.
	 */
	@Test
	public void testSetHour() {
		
		//Instatiate all clocks to be tested against
		DuckClock validClock = new DuckClock(5, 30);
		//DuckClock negativeClockHour = new DuckClock(-4, 0);
		//Test for valid time variables
		
		validClock.setHour(9);
		assertTrue("Hour did not set properly", validClock.getHour() == 9);
		//--- Invalid duckClock instantiation tests ---
		//Test for negative time variables
			
		//Test for out of range top end variables
	}
	
	/**
	 * fourthTest tests setMinute Method
	 * after setting DuckClock to a certain time do checks
	 * to see if after updating the clock using setMinute Method
	 * that that clock's minutes have changed to the set minute
	 */
	@Test
	public void testSetMinute() {
		
		//Instatiate all clocks to be tested against
		DuckClock validClock = new DuckClock(5, 30);
		//DuckClock negativeClockHour = new DuckClock(-4, 0);
		//Test for valid time variables
		
		validClock.setMinute(57);
		assertTrue("Minute did not set properly", validClock.getMinute() == 57);
		//--- Invalid duckClock instantiation tests ---
		//Test for negative time variables
			
		//Test for out of range top end variables
	}
}
