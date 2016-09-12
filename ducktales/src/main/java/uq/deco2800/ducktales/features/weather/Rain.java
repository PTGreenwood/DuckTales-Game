package uq.deco2800.ducktales.features.weather;

/**
 * Properties for weather type: RAIN 
 * 
 * @author mattyleggy
 *
 */
public class Rain implements Weather {
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect("rain.gif");		
		return weatherEffect;
	}
	
	//rain event occurs on land
	public boolean isLand() {
		return true;
	}
	
	//rain event occurs on water
	public boolean isWater() {
		return true;
	}
	
	//raint even occurs on both land and water
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toLowerCase();
	}
}
