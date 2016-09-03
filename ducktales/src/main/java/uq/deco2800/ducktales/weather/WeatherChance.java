package uq.deco2800.ducktales.weather;

public class WeatherChance {

	// weather event that could occur
	private Weather weather;

	// percentage chance of weather event occurring
	private int chance;

	/*
	 * invariant: chance >= 0
	 * 
	 * && chance <= 100
	 * 
	 */

	/**
	 * chance <= 100 && chance >= 0
	 * 
	 * @param weather
	 * @param chance
	 * @throws InvalidWeatherChanceException
	 * 		if chance < 0 || chance > 100
	 */
	public WeatherChance(Weather weather, int chance)
			throws InvalidWeatherChanceException {
		this.weather = weather;
		if (chance < 0 || chance > 100)
			throw new InvalidWeatherChanceException(
					"Chance must be >= 0 && <= 100");
		this.chance = chance;
	}
	
	public int getChance() {
		return this.chance;
	}
	
	public Weather getWeather() {
		return this.weather;
	}
}
