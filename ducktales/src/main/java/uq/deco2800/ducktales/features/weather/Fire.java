package uq.deco2800.ducktales.features.weather;

/**
 * 
 * Weather type: FIRE
 * 
 * Store and retrieve all of the weather related activity of this type of
 * weather.
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

	// Fire occurs on land
	@Override
	public boolean isLand() {
		return true;
	}

	// Fire does not occur on water
	public boolean isWater() {
		return false;
	}

	// Fire stops in rain
	public boolean isRaining() {
		return false;
	}

	// Fire occurs on land only.
	public boolean isAmphibious() {
		return isLand() && isWater();
	}

	public boolean requiresObjectUpdate() {
		return false;
	}
}
