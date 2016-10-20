package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

import uq.deco2800.ducktales.features.time.TimeManager;

public class WeatherManagerTest {
	@Test
	public void testSomething() {
		WeatherManager weatherManager = new WeatherManager();
		TimeManager timeManager = new TimeManager();
		weatherManager.setTimeManager(timeManager);
		
		TimeManager timeManager2 = weatherManager.getTimeManager();
		Assert.assertEquals(timeManager, timeManager2);
		
		
		
	}
}
