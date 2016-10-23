package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

public class FireTest {
	/**
	 * Test the weather effect to check that the default settings are correct.
	 */
	@Test
	public void fireTest() {
		Fire weather = new Fire();
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "fire.gif");
		Assert.assertFalse(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertFalse(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}
}
