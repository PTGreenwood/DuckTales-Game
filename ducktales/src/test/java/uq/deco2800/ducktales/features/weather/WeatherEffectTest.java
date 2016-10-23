package uq.deco2800.ducktales.features.weather;

import org.junit.Test;
import org.junit.Assert;

public class WeatherEffectTest {
	/**
	 * Test the WeatherEffect class with setters and getters
	 */
	@Test
	public void testWeatherEffects() {
		WeatherEffect effect = new WeatherEffect("fire.gif");
		Assert.assertEquals(effect.toString(), null);
		Assert.assertEquals(effect.getName(), null);
		
		//change name of effect and test
		effect.setName("rain");
		Assert.assertEquals(effect.getName(), "rain");
		
		effect.setName(null);
		Assert.assertEquals(effect.getName(), null);
		
		Assert.assertEquals(effect.getFileName(), "fire.gif");
		Assert.assertEquals(effect.getSprite(),
				effect.getLocation() + effect.getFileName());
		
		effect.setFileName("test");
		Assert.assertEquals(effect.getSprite(),
				effect.getLocation() + effect.getFileName());
		
		effect.setFileName(null);
		Assert.assertEquals(effect.getSprite(),
				effect.getLocation() + effect.getFileName());
	}
}
