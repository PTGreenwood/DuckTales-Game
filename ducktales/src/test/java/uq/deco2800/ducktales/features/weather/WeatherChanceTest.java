package uq.deco2800.ducktales.features.weather;

import org.junit.Assert;
import org.junit.Test;

public class WeatherChanceTest {
	/**
	 * Test the weather change to check that the classes work correctly.
	 * 
	 * @throws InvalidWeatherChanceException
	 * @throws NullPointerException
	 */
	@Test
	public void correctWeatherChanceTest()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(new Fire(), 5);
		WeatherChance chance2 = new WeatherChance(new Fire(), 5);
		Assert.assertEquals(chance, chance2);
		Assert.assertEquals(chance.hashCode(), chance2.hashCode());
		Assert.assertEquals(chance.getChance(),5);
		Assert.assertEquals(chance.getWeather(),new Fire());
		Assert.assertEquals(chance.toString(),"5% of fire");
		
		chance.setChance(53);
		Assert.assertEquals(chance.getChance(),53);
		Assert.assertEquals(chance.toString(),"53% of fire");		

		WeatherChance chance3 = new WeatherChance(new Rain(), 5);
		WeatherChance chance4 = new WeatherChance(new Fire(), 5);
		Assert.assertNotEquals(chance3, chance4);
	}

	/**
	 * Test to ensure an NullPointerException is thrown when the input is null
	 * 
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 || > 100
	 * @throws NullPointerException
	 *             if a null input is placed into weather
	 */
	@Test(expected = NullPointerException.class)
	public void testWeatherChanceNullException()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(null, 0);
	}

	/**
	 * Test to ensure an InvalidWeatherChanceException is thrown when the chance
	 * is less than 0.
	 * 
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 || > 100
	 * @throws NullPointerException
	 *             if a null input is placed into weather
	 */
	@Test(expected = InvalidWeatherChanceException.class)
	public void testWeatherChanceNegativeInvalidException()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(new Fire(), -50);
	}
	
	/**
	 * Test to ensure an InvalidWeatherChanceException is thrown when the chance
	 * is less than 0.
	 * 
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 || > 100
	 * @throws NullPointerException
	 *             if a null input is placed into weather
	 */
	@Test(expected = InvalidWeatherChanceException.class)
	public void testWeatherChanceNegativeInvalidException2()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(new Fire(), 50);
		chance.setChance(-50);
	}

	/**
	 * Test to ensure an InvalidWeatherChanceException is thrown when the chance
	 * is greater than 100.
	 * 
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 || > 100
	 * @throws NullPointerException
	 *             if a null input is placed into weather
	 */
	@Test(expected = InvalidWeatherChanceException.class)
	public void testWeatherChanceGreaterInvalidException()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(new Fire(), 101);
	}
	
	/**
	 * Test to ensure an InvalidWeatherChanceException is thrown when the chance
	 * is greater than 100.
	 * 
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 || > 100
	 * @throws NullPointerException
	 *             if a null input is placed into weather
	 */
	@Test(expected = InvalidWeatherChanceException.class)
	public void testWeatherChanceGreaterInvalidException2()
			throws NullPointerException, InvalidWeatherChanceException {
		WeatherChance chance = new WeatherChance(new Fire(), 50);
		chance.setChance(110);
	}
}
