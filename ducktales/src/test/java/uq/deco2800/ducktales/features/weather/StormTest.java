package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

public class StormTest {
	/**
	 * Test cyclone to check that the default settings are correct.
	 */
	@Test
	public void fireTest() {
		Storm weather = new Storm(StormType.CYCLONE);
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "cyclone.gif");
		Assert.assertTrue(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}

	/**
	 * Test lightning to check that the default settings are correct.
	 */
	@Test
	public void testLightning() {
		Storm weather = new Storm(StormType.LIGHTNING);
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "lightning.gif");
		Assert.assertTrue(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}

	/**
	 * Test thunder to check that the default settings are correct.
	 */
	@Test
	public void testThunder() {
		Storm weather = new Storm(StormType.THUNDER);
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "thunder.gif");
		Assert.assertTrue(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}

	/**
	 * Test thunder to check that the default settings are correct.
	 */
	@Test
	public void testTornado() {
		Storm weather = new Storm(StormType.TORNADO);
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "tornado.gif");
		Assert.assertTrue(weather.isAmphibious());
		Assert.assertTrue(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}

	/**
	 * Test whirlpool to check that the default settings are correct.
	 */
	@Test
	public void testWhirlpool() {
		Storm weather = new Storm(StormType.WHIRLPOOL);
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(), "whirlpool.gif");
		Assert.assertFalse(weather.isAmphibious());
		Assert.assertFalse(weather.isLand());
		Assert.assertTrue(weather.isWater());
		Assert.assertFalse(weather.requiresObjectUpdate());
	}
}
