package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

public class WeatherEventsTest {
	/**
	 * Test the WeatherEvents with setters and getters
	 */
	@Test
	public void test()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherEvents events = new WeatherEvents();

		Assert.assertEquals(events.getWeatherEvents().size(), 0);
		Assert.assertEquals(events.getWeatherEvents().toString(), "[]");

		WeatherChance chance = new WeatherChance(new Rain(), 50);
		events.add(chance);

		Assert.assertEquals(events.getWeatherEvents().toString(),
				"[50% of rain]");

		events.add(new WeatherChance(new Fire(), 100));

		Assert.assertTrue(events.getWeatherEvents().toString()
				.equals("[50% of rain, 100% of fire]")
				|| events.getWeatherEvents().toString()
						.equals("[100% of fire, 50% of rain]"));

		Weather possibility = events.getWeatherPossibility();
		Assert.assertTrue(
				possibility instanceof Fire || possibility instanceof Rain);

		events.remove(new WeatherChance(new Fire(), 100));
		possibility = events.getWeatherPossibility();

		Assert.assertTrue(
				possibility instanceof Rain || possibility instanceof Sunny);

		events.remove(new WeatherChance(new Rain(), 50));
		possibility = events.getWeatherPossibility();

		Assert.assertTrue(possibility instanceof Sunny);
		
		events.add(new WeatherChance(new Snow(), 50));
		events.add(new WeatherChance(new Rain(), 50));
		events.add(new WeatherChance(new Fire(), 50));
		Assert.assertEquals(events.getWeatherEvents().size(), 3);
		
		events.removeAllWeatherEvents();
		Assert.assertEquals(events.getWeatherEvents().size(), 0);
		Assert.assertEquals(events.getWeatherEvents().toString(), "[]");		
		

	}
}
