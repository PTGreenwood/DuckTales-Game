package uq.deco2800.ducktales.features.weather;

/**
 * Main weather for the game. 
 * 
 * @author mattyleggy
 *
 *
 */
public abstract class Weather {	
	/**
	 * Get the weather effect (sprite) details for weather
	 * 
	 * @return sprite effect
	 */
	public WeatherEffect getWeatherEffect() {		
		WeatherEffect weatherEffect = new WeatherEffect(this.toString()+".gif");		
		return weatherEffect;
	}
	
	/**
	 * Check if the weather event occurs on land
	 * 
	 * @return true or false depending on if it is a land 
	 */
	public boolean isLand() {
		return false;
	}
	
	/**
	 * Check if the weather even occurs on water
	 * 
	 * @return true if weather event occurs over water
	 * 		   false if weather event does not occur over water
	 */
	public boolean isWater() {
		return false;
	}
	
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
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	/**
	 * @return true if an object (e.g. tree) requires an updated sprite
	 * 		   false if an object does not need an updated sprite 
	 */
	public boolean requiresObjectUpdate() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	@Override 
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
