package uq.deco2800.ducktales.weather;


/**
 * @author mattyleggy
 *
 */
public class Storm implements Weather {
	private StormType type;
	public Storm(StormType type) {
		this.type = type;
	}
	
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect();
		return weatherEffect;
	}
	
	public boolean isLand() {
		if (type.equals(StormType.WHIRLPOOL))
			return false;
		return true;
	}
	
	public boolean isWater() {
		return true;
	}
	
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return false;
	}
}
