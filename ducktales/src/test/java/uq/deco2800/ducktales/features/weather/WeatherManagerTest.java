package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.time.TimeManager;

public class WeatherManagerTest {
	@Test
	public void testGettersAndSetters() {
		WeatherManager weatherManager = new WeatherManager();
		
		//Test setting time manager
		TimeManager timeManager = new TimeManager();
		weatherManager.setTimeManager(timeManager);
				
		//Test getting time manager
		TimeManager timeManager2 = weatherManager.getTimeManager();
		Assert.assertEquals(timeManager, timeManager2);
		
		//Test getting season manager
		SeasonManager seasonManager = weatherManager.getSeasonManager();
		Assert.assertEquals(seasonManager, timeManager2.getSeasonManager());		
	}
}
