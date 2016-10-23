package uq.deco2800.ducktales.features.weather;

/**
 * Store and retrieve a weather event and chance of that event from occurring to
 * be used in WeatherEvents.
 * 
 * @author mattyleggy
 *
 */
public class WeatherChance {

	// weather event that could occur
	private Weather weather;

	// percentage chance of weather event occurring
	private int chance;

	/*
	 * invariant:
	 * 
	 * weather must be a valid weather event
	 * 
	 * && chance >= 0
	 * 
	 * && chance <= 100
	 * 
	 */

	/**
	 * Create a WeatherChance with a weather event and a percentage % chance of
	 * that event from occurring.
	 * 
	 * chance <= 100 && chance >= 0
	 * 
	 * @param weather
	 * @param chance
	 * @throws InvalidWeatherChanceException
	 *             if chance < 0 || chance > 100
	 */
	public WeatherChance(Weather weather, int chance)
			throws InvalidWeatherChanceException, NullPointerException {
		this.weather = weather;
		if (weather.equals(null))
			throw new NullPointerException("Weather cannot be null");
		if (chance < 0 || chance > 100)
			throw new InvalidWeatherChanceException(
					"Chance must be >= 0 && <= 100");
		this.chance = chance;
	}

	/**
	 * Get the percentage chance for the weather event
	 * 
	 * @return the percentage chance of the weather event occurring
	 */
	public int getChance() {
		return this.chance;
	}

	/**
	 * Update the chance of the weather event occurring.
	 * 
	 * @param chance
	 *            the percent chance of the event occurring
	 * @throws InvalidWeatherChanceException
	 *             if the chance is < 0 or > 100
	 */
	public void setChance(int chance) throws InvalidWeatherChanceException {
		if (chance < 0 || chance > 100) {
			throw new InvalidWeatherChanceException(
					"Chance must be >= 0 && <= 100");
		}
		this.chance = chance;
	}

	/**
	 * Get the weather that is assigned to a given chance
	 * 
	 * @return the weather event
	 */
	public Weather getWeather() {
		return this.weather;
	}

	@Override
	public String toString() {
		return "" + chance + "% of " + weather.toString();
	}

	@Override
	public boolean equals(Object other) {

		if (other == null) {
			return false;
		}

		if (!(other instanceof WeatherChance)) {
			return false;
		}

		final WeatherChance otherChance = (WeatherChance) other;
		if (!this.weather.equals(otherChance.weather)
				|| this.chance != otherChance.chance) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.weather.hashCode();
		result = prime * result + this.chance;
		return result;
	}
}
