package uq.deco2800.ducktales.weather;

/**
 * Main weather for the game. 
 * 
 * @author mattyleggy
 *
 */
public interface Weather {
	
	/**
	 * Get the weather effect (sprite) details for weather
	 * 
	 * @return sprite effect
	 */
	public WeatherEffect getWeatherEffect();
	
	/**
	 * Check if the weather event occurs on land
	 * 
	 * @return true or false depending on if it is a land 
	 */
	public boolean isLand();
	
	/**
	 * Check if the weather even occurs on water
	 * 
	 * @return true if weather event occurs over water
	 * 		   false if weather event does not occur over water
	 */
	public boolean isWater();
	
	/**
	 * Check if the weather events occurs on:
	 * 
	 * 	  land - isLand() 
	 * 
	 * && water - isWater() 
	 * 
	 * @return true if weather event occurs over both land && water
	 * 		   false if weather event does not occur over both
	 */
	public boolean isAmphibious();
	
	/**
	 * @return true if an object (e.g. tree) requires an updated sprite
	 * 		   false if an object does not need an updated sprite
	 */
	public boolean requiresObjectUpdate();
	
	
}
