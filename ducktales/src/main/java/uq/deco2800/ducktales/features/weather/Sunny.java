package uq.deco2800.ducktales.features.weather;

/**
 * 
 * Weather type: Sunny
 * 
 * Store and retrieve all of the weather related activity of this type of
 * weather.
 * 
 * @author mattyleggy
 *
 */
public class Sunny extends Weather {
	@Override
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect("sunny.gif");
		return weatherEffect;
	}
	
	//occurs on land
	@Override
	public boolean isLand() {
		return true;
	}	
	
	//occurs on water
	public boolean isWater() {
		return true;
	}
	
	//occurs on land only.
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return false;
	}
}
