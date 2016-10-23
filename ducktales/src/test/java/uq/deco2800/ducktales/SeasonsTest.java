package uq.deco2800.ducktales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.seasons.SeasonType;
import uq.deco2800.ducktales.features.time.TimeManager;

public class SeasonsTest {

	/* First Test
	 * 
	 * Tests all getter methods in Seasons
	*/ 
	@Test 
	public void getDetails() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		//Spring Season Testing
		SeasonType correctName = SeasonType.SPRING;
		float correctHumidity = 2.4f;
		int correctMaxTemperature = 20;
		int correctcurrentTemperature = 13;
		int correctMinTemperature = 11;
		int correctTimeNightFall = 19;
		int correctTimeDayBreak = 6;
		float correctAtmosphericIceLevel = 0.0f;
		float correctWindLevel = 2.0f;
		float correctFireDanger = 0.8f;
		
		assertEquals(correctName, tm.getSeasonManager().getCurrentSeason().getName());
		
	}
	
	/*
	 * Second test.
	 * 
	 * Test set methods and get methods on the new non static values.
	 */
	@Test
	public void setDetails() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		
	}
}