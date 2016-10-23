package uq.deco2800.ducktales.features.weather;

import org.junit.Test;
import org.junit.Assert;

public class SunnyTest {
	/**
	 * Test the weather effect to check that the default settings are correct.
	 */
	@Test
	public void sunnyTest() {
		Sunny sunny = new Sunny();
		WeatherEffect weatherEffect = sunny.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(),"sunny.gif");
		Assert.assertTrue(sunny.isAmphibious());
		Assert.assertTrue(sunny.isLand());
		Assert.assertTrue(sunny.isWater());
		Assert.assertFalse(sunny.requiresObjectUpdate());
	}
}
