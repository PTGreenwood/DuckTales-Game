package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.features.weather.Fire;
import uq.deco2800.ducktales.features.weather.InvalidWeatherChanceException;
import uq.deco2800.ducktales.features.weather.Rain;
import uq.deco2800.ducktales.features.weather.Snow;
import uq.deco2800.ducktales.features.weather.Weather;
import uq.deco2800.ducktales.features.weather.*;
import uq.deco2800.ducktales.features.weather.WeatherChance;
import uq.deco2800.ducktales.features.weather.WeatherEvents;

/**
 * an abstract class that sets the basic methods for each in game season
 * 
 *
 */

public abstract class Season {

	// Variable declaration for each Season
	protected String name;
	protected float humidityLevel;
	protected int minTemperature;
	protected int currentTemperature;
	protected int maxTemperature;
	protected int timeNightFall;
	protected int timeDayBreak;

	public WeatherEvents weatherEvents;

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
	
	/**
	 * Gets a list of weatherEvents that take place within this Season
	 * 
	 * @return HashSet<> containing event and chance for events.
	 */
	
	public WeatherEvents getSeasonalWeatherEvents() {
		return this.weatherEvents;
	}
	
	/**
	 * Returns the current temperature of the day in the season
	 * 
	 * @return int - currentTemperature
	 */
	
	public int getCurrentTemperature() {
		return this.currentTemperature;
	}
	
	
	/**
	 * Sets rainWeather Event/Chance for Spring Time
	 */
	public void setRainWeather() {
		
		int initialRainChance = (int) (this.humidityLevel * this.currentTemperature);

		Weather rain = new Rain();
    	try {
    		WeatherChance rainChance = new WeatherChance(rain, initialRainChance);
    		this.weatherEvents.add(rainChance);

    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/*
	 * Sets Fire Weather Event for Spring Time
	*/
	public void setFireWeather() {
		
		//Making this fairly static at the moment
		//Keeping a note here: CurrentTemperature should be increasing/decreasing as the
		//day keeps moving on which means the chances should be constantly updating. But for now
		//they can be static until implementation is ready for that sort of thing.
		int initialFireChance = (int) (this.humidityLevel * this.currentTemperature);
		
		Weather fire = new Fire();
    	try {
    		WeatherChance fireChance = new WeatherChance(fire, initialFireChance);
    		this.weatherEvents.add(fireChance);

    	}  catch (Exception e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/**
	 * Sets snowWeather Event/Chance for Spring Time
	 */
	public void setSnowWeather() {		
		int initialSnowChance = 5;
		Weather snow = new Snow();
    	try {
    		WeatherChance snowChance = new WeatherChance(snow, initialSnowChance);
    		this.weatherEvents.add(snowChance);
    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/**
	 * Sets snowWeather Event/Chance for Spring Time
	 */
	public void setStormWeather() {		
		int initialStormChance = 5;
		Weather storm = new Storm(StormType.THUNDER);
    	try {
    		WeatherChance stormChance = new WeatherChance(storm, initialStormChance);
    		this.weatherEvents.add(stormChance);
    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/*
	 * Currently Storm class has not been fully implemented. Uncomment when ready
	 */
	/**
	 * Sets Storm Weather Event for Spring Time
	 **/
	/*
	public void setStormWeather() {
		
		//Making this fairly static at the moment
		//Keeping a note here: CurrentTemperature should be increasing/decreasing as the
		//day keeps moving on which means the chances should be constantly updating. But for now
		//they can be static until implementation is ready for that sort of thing.
		int initialStormChance = (int) (this.humidityLevel * this.maxTemperature);
		Storm storm = new Storm();
    	try {
    		WeatherChance stormChance = new WeatherChance(storm, initialStormChance);
    		super.weatherEvents.add(stormChance);

    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	*/
}
