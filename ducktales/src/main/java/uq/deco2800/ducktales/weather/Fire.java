package uq.deco2800.ducktales.weather;

/**
 * 
 * @author mattyleggy
 *
 */
public class Fire implements Weather {
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect();
		return weatherEffect;
	}
	
	public boolean isLand() {
		return true;
	}
	
	public boolean isWater() {
		return false;
	}
	
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return true;
	}
}
