package uq.deco2800.ducktales.features.weather;

import org.junit.Test;
import org.junit.Assert;

public class SnowTest {
	@Test
	public void snowTest() {
		Snow snow = new Snow();
		WeatherEffect weatherEffect = snow.getWeatherEffect();
		Assert.assertEquals(weatherEffect.getFileName(),"rain.gif");
		Assert.assertTrue(snow.isAmphibious());
		Assert.assertTrue(snow.isLand());
		Assert.assertTrue(snow.isWater());
		Assert.assertFalse(snow.requiresObjectUpdate());
	}
}
