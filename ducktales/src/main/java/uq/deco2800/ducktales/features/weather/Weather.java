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
	 * Check if it is currently raining
	 * Returns true has the possibility of turning into a storm, or snow depends of the seasons
	 * Fire can't stay in rain
	 * 
	 * @return true if it is raining
	 * 		   false if is not raining
	 */
	public boolean isRaining() {
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
	public boolean equals(Object other) {
		
		if (other == null) {
			return false;
		}
		
		if (!(other instanceof Weather)) {
			return false;
		}
		
		final Weather otherWeather = (Weather) other;
		if (!this.toString().equals(otherWeather.toString())) {
			return false;
		}
		
		return true;
	}
	
	@Override 
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
