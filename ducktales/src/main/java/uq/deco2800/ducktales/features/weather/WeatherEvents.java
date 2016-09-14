package uq.deco2800.ducktales.features.weather;

import java.util.*;

/**
 * @author mattyleggy
 *
 */
public class WeatherEvent {
	//list of weather events
	private HashSet<WeatherChance> weatherEvents;
	
	/**
	 * An empty list of weather events is constructed.
	 * 	 * 
	 */
	public WeatherEvent() {
		this.weatherEvents = new HashSet<>(); 
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
	public void add(WeatherChance weatherChance) {
		weatherEvents.add(weatherChance);
	}
	
	/**
	 * Remove a WeatherChance from the list of weather events.
	 * 
	 * @param weatherChance
	 */
	public void remove(WeatherChance weatherChance) {
		weatherEvents.remove(weatherChance);
	}
	
	
}
