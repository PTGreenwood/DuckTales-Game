package uq.deco2800.ducktales.features.weather;

import java.util.*;
import org.junit.*;
import uq.deco2800.ducktales.features.weather.*;

/**
 * 
 * 
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
		Assert.assertEquals(false, fire.requiresObjectUpdate());		

		Rain rain = new Rain();
		Assert.assertEquals(true, rain.isLand());
		Assert.assertEquals(true, rain.isWater());
		Assert.assertEquals(true, rain.isAmphibious());
		Assert.assertEquals(false, rain.requiresObjectUpdate());

		StormType type = StormType.WHIRLPOOL;
		Storm storm = new Storm(type);
		Assert.assertEquals(false, storm.isLand());
		Assert.assertEquals(true, storm.isWater());
		Assert.assertEquals(false, storm.isAmphibious());
		Assert.assertEquals(false, storm.requiresObjectUpdate());

		type = StormType.LIGHTNING;
		storm = new Storm(type);
		Assert.assertEquals(true, storm.isLand());
		Assert.assertEquals(true, storm.isWater());
		Assert.assertEquals(true, storm.isAmphibious());
		Assert.assertEquals(false, storm.requiresObjectUpdate());

		Weather weather = new Fire();
		Assert.assertEquals(true, weather.isLand());
		Assert.assertEquals(false, weather.isWater());
		Assert.assertEquals(false, weather.isAmphibious());
		Assert.assertEquals(false, weather.requiresObjectUpdate());
	}
	
	/**
	 * Test Weather toString methods
	 */
	@Test
	public void testToString() {
		Fire fire = new Fire();
		Assert.assertEquals("fire", fire.toString());
		Assert.assertFalse(fire.toString().equals("FIRE"));

		Rain rain = new Rain();
		Assert.assertEquals("rain", rain.toString());

		StormType type = StormType.WHIRLPOOL;
		Storm storm = new Storm(type);
		Assert.assertEquals("whirlpool", storm.toString());

		type = StormType.LIGHTNING;
		storm = new Storm(type);
		Assert.assertEquals("lightning", storm.toString());

		Weather weather = new Fire();
		Assert.assertEquals("fire", weather.toString());
	}

	/**
	 * 
	 * @throws InvalidWeatherChanceException
	 */
	@Test
	public void testWeatherChance() throws InvalidWeatherChanceException {
		Rain rain = new Rain();
		WeatherChance wc = new WeatherChance(rain, 50);
		Assert.assertEquals("50% of rain", wc.toString());

		Fire fire = new Fire();
		wc = new WeatherChance(fire, 50);
		Assert.assertEquals("50% of fire", wc.toString());

		StormType type = StormType.WHIRLPOOL;
		Storm storm = new Storm(type);
		wc = new WeatherChance(storm, 50);
		Assert.assertEquals("50% of whirlpool", wc.toString());

		type = StormType.LIGHTNING;
		storm = new Storm(type);
		wc = new WeatherChance(storm, 50);
		Assert.assertEquals("50% of lightning", wc.toString());

		wc = new WeatherChance(storm, 30);
		Assert.assertEquals("30% of lightning", wc.toString());

		wc = new WeatherChance(storm, 100);
		Assert.assertEquals("100% of lightning", wc.toString());

		wc = new WeatherChance(storm, 0);
		Assert.assertEquals("0% of lightning", wc.toString());
	}

	@Test
	public void testWeatherEvent() throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		WeatherChance rainChance = new WeatherChance(new Rain(), 50);
		WeatherChance fireChance = new WeatherChance(new Fire(), 30);
		weatherEvent.add(rainChance);
		weatherEvent.add(fireChance);
	}

	@Test(expected = InvalidWeatherChanceException.class)
	public void testWeatherChanceException()
			throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		WeatherChance rainChance = new WeatherChance(new Rain(), -1);
		weatherEvent.add(rainChance);
	}

	@Test(expected = NullPointerException.class)
	public void testWeatherChanceException2()
			throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		WeatherChance rainChance = new WeatherChance(null, 50);
		weatherEvent.add(rainChance);
	}

	@Test
	public void testEquals() {
		Weather fire = new Fire();
		Weather rain = new Rain();
		Weather rain2 = new Rain();
		WeatherEvents we = new WeatherEvents();
	}

	@Test
	public void testHashCodes() throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		HashSet<WeatherChance> wc = new HashSet<>();
		Assert.assertEquals(wc.hashCode(),
				weatherEvent.getWeatherEvents().hashCode());
		wc.add(new WeatherChance(new Rain(), 50));
		wc.add(new WeatherChance(new Fire(), 30));

		WeatherChance rainChance = new WeatherChance(new Rain(), 50);
		WeatherChance fireChance = new WeatherChance(new Fire(), 30);
		weatherEvent.add(rainChance);
		weatherEvent.add(fireChance);
		
		Assert.assertEquals(wc.hashCode(),
				weatherEvent.getWeatherEvents().hashCode());

		weatherEvent.remove(rainChance);
		
		WeatherEvents testEvents = new WeatherEvents();
		testEvents.add(new WeatherChance(new Fire(), 30));
	}
	
	@Test
	public void testWeatherEffect() {
		Fire fire = new Fire();
		WeatherEffect we = fire.getWeatherEffect();		
		Assert.assertEquals(null,we.getName());
		we.setName("Fire");
		Assert.assertEquals("Fire",we.getName());
		we.setName("Name");
		Assert.assertEquals("Name",we.getName());
		String location = we.getLocation();
		Assert.assertEquals(location+"fire.gif",we.getSprite());
		
		Rain rain = new Rain();
		we = rain.getWeatherEffect();		
		Assert.assertEquals(null,we.getName());
		we.setName("Rain");
		Assert.assertEquals("Rain",we.getName());
		we.setName("Name");
		Assert.assertEquals("Name",we.getName());
		location = we.getLocation();
		Assert.assertEquals(location+"rain.gif",we.getSprite());
	}

}
