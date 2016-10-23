package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

public class RainTest {
	/**
	 * Test the weather effect to check that the default settings are correct.
	 */
	@Test
	public void rainTest() {
		Rain weather = new Rain();
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "rain.gif");
		Assert.assertTrue(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}
}
