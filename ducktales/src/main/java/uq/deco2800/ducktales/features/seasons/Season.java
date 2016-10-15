package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;

/**
 * an abstract class that sets the basic methods for each in game season
 * 
 * @author felicia
 *
 */

public abstract class Season {

	// Variable declaration for each Season
	protected String name;
	protected float humidityLevel;
	protected int minTemperature;
	protected int maxTemperature;
	protected int timeNightFall;
	// 24Hour time (integer is hour. so getHour() will be able to retrieve it
	protected int timeDayBreak;
	// 24Hour time (integer is hour. so getHour() will be able to retrieve it

	public Season() {

	}

	/**
	 * Getter Method: getName(); returns the name of the season in string format
	 * 
	 * @return String: Name
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * Getter Method: getHumidity() gets the Humidity value of the current
	 * season
	 * 
	 * @return Float: Humidity
	 */
	public float getHumidity() {
		return this.humidityLevel;
	}

	/**
	 * Getter Method: getMinTemp() gets the minimum temperature value of the
	 * current season
	 * 
	 * @return Int: Minimum Temperature
	 */
	public int getMinTemp() {
		return this.minTemperature;
	}

	/**
	 * Getter Method: getMaxTemp() gets the maximum temperature value of the
	 * current season
	 * 
	 * @return Int: Maximum Temperature
	 */
	public int getMaxTemp() {
		return this.maxTemperature;
	}

	/**
	 * Getter Method: getTimeNightFall() gets the time that nightfall happens
	 * for the current season
	 * 
	 * @return Int: Hour value for when Nightfall begins
	 */
	public int getTimeNightFall() {
		return this.timeNightFall;
	}

	/**
	 * Getter Method: getTimeDayBreak() gets the time that daybreak happens for
	 * the current season
	 * 
	 * @return Int: Hour value for when DayBreak begins
	 */
	public int getTimeDayBreak() {
		return this.timeDayBreak;
	}
}
