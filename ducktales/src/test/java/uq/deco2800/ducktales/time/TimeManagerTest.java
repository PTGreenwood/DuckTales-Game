package uq.deco2800.ducktales.time;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;

public class TimeManagerTest {

	@Test // Testing the isNight method
	public void testIfIsNight() {
		
		TimeManager timeManager = new TimeManager();
		SeasonManager seasonManager = new SeasonManager();
		
		int nightHour = 1;
		timeManager.setTime(nightHour);
		timeManager.setSeasonManager(seasonManager);

		assertEquals(timeManager.isNight(), true);
		
		int dayHour = 11;
		timeManager.setTime(dayHour);
		
		assertEquals(timeManager.isNight(), false);
	}
	
	@Test // Testing Set Methods Correct.
	public void testAllSetMethodsCorrect() {

		TimeManager timeManager = new TimeManager();
		SeasonManager seasonManager = new SeasonManager();

		int correctHour = 7;

		// SetHour (old hour is 0 by default)
		timeManager.setTime(correctHour);
		
		timeManager.setSeasonManager(seasonManager);

		assertEquals(timeManager.getGameTimeObject().getHour(), correctHour);
		assertEquals(timeManager.getSeasonManager(), seasonManager);

	}
	
	@Test // Testing get Methods Correct
	public void testAllGetMethodsCorrect() {

		TimeManager timeManager = new TimeManager();
		
		assertEquals(timeManager.getSeasonManager(), timeManager.seasonManager);

	}

	
	
}
