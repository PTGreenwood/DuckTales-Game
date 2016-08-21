package uq.deco2800.ducktales.weather;

import org.junit.*;

/**
 * Last modified: 21 August 2016 by mattyleggy
 * @author mattyleggy
 *
 */
public class WeatherTest {
	
	/**
	 * Test weather events 
	 */
	@Test 
	public void testWeather() {
		Fire fire = new Fire();		
		Assert.assertEquals(true, fire.isLand());
		Assert.assertEquals(false, fire.isWater());
		Assert.assertEquals(false, fire.isAmphibious());
			
		Rain rain = new Rain();		
		Assert.assertEquals(true, rain.isLand());
		Assert.assertEquals(true, rain.isWater());
		Assert.assertEquals(true, rain.isAmphibious());
		
		StormType type = StormType.WHIRLPOOL;
		Storm storm = new Storm(type);		
		Assert.assertEquals(false, storm.isLand());
		Assert.assertEquals(true, storm.isWater());
		Assert.assertEquals(false, storm.isAmphibious());
	}
	
	
	/**
	 * Not sure if I will need this?
	 * @param weather
	 */
	private void testEvent(Weather weather) {
		
	}
}
