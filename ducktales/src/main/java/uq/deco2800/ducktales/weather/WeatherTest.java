package uq.deco2800.ducktales.weather;

import org.junit.*;

/**
 * 
 * @author mattyleggy
 *
 */
public class WeatherTest {
	@Test 
	public void testFire() {
		Weather weather = new Fire();		
		Assert.assertEquals(true, weather.isLand());
		Assert.assertEquals(false, weather.isWater());
	}
	
	public void testRain() {
		
	}
}
