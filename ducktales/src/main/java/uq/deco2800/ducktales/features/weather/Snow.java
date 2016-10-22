package uq.deco2800.ducktales.features.weather;

/**
 * Properties for weather type: SNOW 
 * 
 * Store and retrieve all of the weather related activity of this type of
 * weather.
 * 
 * @author mattyleggy
 *
 */
public class Snow extends Weather {
	@Override
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect("rain.gif");		
		return weatherEffect;
	}
	
	//rain event occurs on land
	@Override
	public boolean isLand() {
		return true;
	}
	
	//rain event occurs on water
	@Override
	public boolean isWater() {
		return true;
	}
	
	//rain even occurs on both land and water
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return false;
	}
}
