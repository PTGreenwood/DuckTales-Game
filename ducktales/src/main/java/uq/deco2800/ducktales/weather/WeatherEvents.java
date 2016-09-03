package uq.deco2800.ducktales.weather;

import java.util.*;

/**
 * @author mattyleggy
 *
 */
public class WeatherEvents {
	//list of weather events
	private HashSet<WeatherChance> weatherEvents;
	
	/**
	 * @param weatherEvents
	 */
	public WeatherEvents(HashSet<WeatherChance> weatherEvents) {
		this.weatherEvents = weatherEvents; 
	}
	
	/**
	 * Get all the weather events.
	 * 
	 * @return
	 */
	public HashSet<WeatherChance> getWeatherEvents() {
		//need to change this to return a "clone".
		return this.weatherEvents;
	}
	
	/**
	 * Add a WeatherChance to the list of weather events.
	 * 
	 * @param weatherChance
	 */
	public void addWeatherChance(WeatherChance weatherChance) {
		weatherEvents.add(weatherChance);
	}
	
	/**
	 * Remove a WeatherChance from the list of weather events.
	 * 
	 * @param weatherChance
	 */
	public void removeWeatherChance(WeatherChance weatherChance) {
		weatherEvents.remove(weatherChance);
	}
	
	
}
