package uq.deco2800.ducktales.features.weather;

import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author mattyleggy
 *
 */
public class WeatherEvents {
	// list of weather events
	private HashSet<WeatherChance> weatherEvents;

	/**
	 * An empty list of weather events is constructed. *
	 */
	public WeatherEvents() {
		this.weatherEvents = new HashSet<>();
	}

	/**
	 * Get all the weather events.
	 * 
	 * @return
	 */
	public HashSet<WeatherChance> getWeatherEvents() {
		HashSet<WeatherChance> eventsClone = new HashSet<WeatherChance>();
		for (WeatherChance weatherChance : weatherEvents) {
			eventsClone.add(weatherChance);
		}
		return eventsClone;
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

	/**
	 * Get the size of the Weather Events list
	 * 
	 * @return the size of the Weather Events list
	 */
	public int size() {
		return weatherEvents.size();
	}

	@Override
	public String toString() {
		String returnString = "";
		Iterator<WeatherChance> iterator = weatherEvents.iterator();
		while (iterator.hasNext()) {
			WeatherChance weatherChance = iterator.next();
			returnString += weatherChance.toString();
			if (iterator.hasNext())
				returnString += ", ";
		}
		return "[" + returnString + "]";
	}

	@Override
	public boolean equals(Object other) {

		if (other == null) {
			return false;
		}

		if (!(other instanceof WeatherEvents)) {
			return false;
		}

		final WeatherEvents otherEvent = (WeatherEvents) other;
		if (!this.getWeatherEvents().equals(otherEvent.getWeatherEvents())) {
			return false;
		}

		return true;
	}

	/**
	 * Get a random weather event based on the chance of that event occurring.
	 * 
	 * @return a random Weather event if there is a chance of one occurring
	 *         otherwise null.
	 */
	public Weather getWeatherPossibility() {		
		Random random = new Random();
		int percent = random.nextInt(100) + 1; // random number from 1 - 100
		ArrayList<WeatherChance> possibilities = new ArrayList<>();		
		for (WeatherChance chance : this.weatherEvents) {
			if (percent <= chance.getChance())
				possibilities.add(chance);
		}
		
		if (possibilities.size() > 0) {			
			Random randomChance = new Random();			
			int randomPick = randomChance.nextInt(possibilities.size());			
			return possibilities.get(randomPick).getWeather();
		}
		return new Fire();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getWeatherEvents().hashCode();
		return result;
	}

	/*
	 * @Override public boolean equals(Object object) { System.out.println("a");
	 * if (!(object instanceof WeatherEvents)) return false; WeatherEvents other
	 * = (WeatherEvents) object; return
	 * (this.getWeatherEvents().contains(other.getWeatherEvents())); }
	 */
}
