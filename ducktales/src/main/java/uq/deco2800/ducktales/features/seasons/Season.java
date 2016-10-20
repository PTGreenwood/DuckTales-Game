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
	protected float atmosphericIceLevel;
	protected float windLevel;
	protected float fireDanger;
	

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
	 * Returns the current temperature of the day in the season
	 * 
	 * @return float - Ice Level
	 */
	
	public float getAtmosphericIceLevel() {
		return this.atmosphericIceLevel;
	}
	
	/**
	 * Returns the current temperature of the day in the season
	 * 
	 * @return float - windLevel
	 */
	
	public float getWindLevel() {
		return this.windLevel;
	}
	
	/**
	 * Returns the current temperature of the day in the season
	 * 
	 * @return float - fireDanger
	 */
	
	public float getFireDanger() {
		return this.fireDanger;
	}
	/**
	 * Sets the humidity for the season
	 * 
	 * @param float: newHumidity
	 * 			- the value to update the humidity to.
	 */
	public void setHumidity(float newHumidity) {
		if(newHumidity < 0) {
		//Do nothing
		} else {
			this.humidityLevel = newHumidity;
		}
	}
	
	/**
	 * Sets the minimum temperature for the season
	 * 
	 * @param float: newMinTemp
	 * 			- the value to update the minimum Temperature to.
	 */
	public void setMinimumTemperature(int newMinTemp) {
		this.minTemperature = newMinTemp;
	}
	
	/**
	 * Sets the maximum temperature for the season
	 * 
	 * @param float: newMaxTemp
	 * 			- the value to update the maximum Temperature to.
	 */
	public void setMaximumTemperature(int newMaxTemp) {
		this.maxTemperature = newMaxTemp;
	}
	
	/**
	 * Sets the time of sunrise for the season
	 * 
	 * @param float: newSunriseTime
	 * 			- the value to update the time of daybreak to
	 */
	public void setSunrise(int newSunriseTime) {
		if(newSunriseTime < 0 || newSunriseTime > 23) {
			//Do Nothing.
		} else {
			this.timeDayBreak = newSunriseTime;
		}
	}
	
	/**
	 * Sets the time of sunset for the season
	 * 
	 * @param float: newSunsetTime
	 * 			- the value to update the time of sunset to
	 */
	public void setSunset(int newSunsetTime) {
		if(newSunsetTime < 0 || newSunsetTime > 23) {
			//Do Nothing.
		} else {
		this.timeNightFall = newSunsetTime;
		} 
	}
	
	/**
	 * Sets the ice level of the atmosphere for this season
	 * 
	 * @param float: newIceLevel
	 * 			- the value to update the icelevel to
	 */
	public void setAtmosphericIceLevel(float newIceLevel) {
		if(newIceLevel < 0) {
			//Do Nothing.
		} else {
		this.atmosphericIceLevel = newIceLevel;
		} 
	}
	
	/**
	 * Sets the amount of wind for the season
	 * 
	 * @param float: newWindLevel
	 * 			- the value to update the amount of wind
	 */
	public void setWindlevel(float newWindLevel) {
		if(newWindLevel < 0) {
			//Do Nothing.
		} else {
		this.windLevel = newWindLevel;
		} 
	}
	
	/**
	 * Sets the fireDanger for the season
	 * 
	 * @param float: newfireDanger
	 * 			- the value to update the time of sunset to
	 */
	public void setFireDanger(float newFireDanger) {
		if(newFireDanger < 0) {
			//Do Nothing.
		} else {
		this.fireDanger = newFireDanger;
		} 
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
		//day keeps moving on which means the chances should be constantly updating. 
		int initialFireChance = (this.currentTemperature );
		
		Weather fire = new Fire();
    	try {
    		WeatherChance fireChance = new WeatherChance(fire, initialFireChance);
    		this.weatherEvents.add(fireChance);

    	}  catch (Exception e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/**
	 * Sets snowWeather Event/Chance
	 */
	public void setSnowWeather() {	
		int initialSnowChance;
		if(this.atmosphericIceLevel > 0) {
			initialSnowChance = (int) (100 - (this.currentTemperature * this.atmosphericIceLevel));
		} else {
			initialSnowChance = 0;
		}
		Weather snow = new Snow();
    	try {
    		WeatherChance snowChance = new WeatherChance(snow, initialSnowChance);
    		this.weatherEvents.add(snowChance);
    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}
	
	/**
	 * Sets snowWeather Event/Chance
	 */
	public void setStormWeather() {		
		int initialStormChance = (int) ((this.currentTemperature * this.humidityLevel) - 
				(((this.humidityLevel * this.currentTemperature) / this.windLevel)));
		Weather storm = new Storm(StormType.THUNDER);
    	try {
    		WeatherChance stormChance = new WeatherChance(storm, initialStormChance);
    		this.weatherEvents.add(stormChance);
    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
	}

	/**
	 * Updates the currentTemperature by incrementing current value
	 * of the season by the provided modifier
	 * of the provided modifier.
	 * @param modifier
	 * 			-Must be positive
	 * 
	 * @require 0 >= modifier
	 */
	public void incrementCurrentTemperature(int modifier) {
		if(modifier <= 0) {
			//Do nothing.
		} else {
		
			if((this.currentTemperature < this.maxTemperature)) {
				int newTemperature = this.currentTemperature + modifier;
				for (int i = 0; i < modifier; i++) {
					if(newTemperature > this.maxTemperature) {
						newTemperature -= 1;
					} else {
						this.currentTemperature = newTemperature;
					}
				}		
			}
		}
	}
	
	/**
	 * Updates the currentTemperature by decrementing current Value
	 * of the season by the provided modifier.
	 * @param modifier
	 * 			-Must be positive
	 * 
	 * @require 0 >= modifier
	 */
	public void decrementCurrentTemperature(int modifier) {
		if(modifier <= 0) {
			//Do nothing.
		} else {
			if((this.currentTemperature > this.minTemperature)) {
				int newTemperature = this.currentTemperature - modifier;
				for (int i = 0; i < modifier; i++) {
					if(newTemperature < this.minTemperature) {
						newTemperature += 1;
					} else {
						this.currentTemperature = newTemperature;
						break;
					}
				}		
			}
		}
	}
}
