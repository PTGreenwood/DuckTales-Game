package uq.deco2800.ducktales.features.weather;

/**
 * 
 * Weather type: FIRE
 * 
 * @author mattyleggy
 *
 */
public class Fire extends Weather {
	public Fire() {
		
	}
	
	@Override
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect("fire.gif");
		return weatherEffect;
	}
	
	//Fire occurs on land
	@Override
	public boolean isLand() {
		return true;
	}	
	
	//Fire does not occur on water
	public boolean isWater() {
		return false;
	}
	
	//Fire occurs on land only.
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return false;
	}
}
