package uq.deco2800.ducktales;

import java.util.*;

import org.junit.*;

import ch.qos.logback.core.net.SyslogOutputStream;
import uq.deco2800.ducktales.weather.*;

/**
 * Last modified: 21 August 2016 by mattyleggy
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
	 * 
	 * @param weather
	 * @throws InvalidWeatherChanceException
	 */
	@Test
	public void testWeatherChance() throws InvalidWeatherChanceException {		
		Weather rain = new Rain();
		WeatherChance wc = new WeatherChance(rain, 50);
		Assert.assertEquals("50% of rain", wc.toString());
		System.out.println(wc);
		
	}
	
	@Test
	public void testWeatherEvent() throws InvalidWeatherChanceException {
		WeatherEvent weatherEvent = new WeatherEvent();
		WeatherChance rainChance = new WeatherChance(new Rain(),50);
		WeatherChance fireChance = new WeatherChance(new Fire(),30);
		weatherEvent.add(rainChance);
		weatherEvent.add(fireChance);
		System.out.println(weatherEvent.getWeatherEvents());		
	}
}
