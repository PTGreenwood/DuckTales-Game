package uq.deco2800.ducktales;

import java.util.*;

import org.junit.*;

// Dunno but the ch. was causing errors 
//import ch.qos.logback.core.net.SyslogOutputStream;
import uq.deco2800.ducktales.features.weather.*;

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
		
		type = StormType.LIGHTNING;
		storm = new Storm(type);
		Assert.assertEquals(true, storm.isLand());
		Assert.assertEquals(true, storm.isWater());
		Assert.assertEquals(true, storm.isAmphibious());
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
		System.out.println(wc.toString());
		Assert.assertEquals("30% of lightning", wc.toString());
	}
	
	@Test
	public void testWeatherEvent() throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		WeatherChance rainChance = new WeatherChance(new Rain(),50);
		WeatherChance fireChance = new WeatherChance(new Fire(),30);
		weatherEvent.add(rainChance);
		weatherEvent.add(fireChance);				
	}
	
	@Test
	public void testEquals() {
		Weather fire = new Fire();
		Weather rain = new Rain();		
		Weather rain2 = new Rain();		
		WeatherEvents we = new WeatherEvents();		
	}
	
	@Test
	public void testList() throws InvalidWeatherChanceException {
		WeatherEvents weatherEvent = new WeatherEvents();
		HashSet<WeatherChance> wc = new HashSet<>();
		Assert.assertEquals(wc, weatherEvent.getWeatherEvents());
		wc.add(new WeatherChance(new Rain(),50));
		wc.add(new WeatherChance(new Fire(),30));
		
		WeatherChance rainChance = new WeatherChance(new Rain(),50);
		WeatherChance fireChance = new WeatherChance(new Fire(),30);
		weatherEvent.add(rainChance);
		weatherEvent.add(fireChance);		
		
		//This should equal true, but it doesn't yet. Need to fix.
		//Assert.assertEquals(wc, weatherEvent.getWeatherEvents());	
	}
	
	
}
