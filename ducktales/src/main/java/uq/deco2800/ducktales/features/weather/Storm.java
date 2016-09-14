package uq.deco2800.ducktales.features.weather;


/**
 * @author mattyleggy
 *
 */
public class Storm extends Weather {
	private StormType type;
	public Storm(StormType type) {
		this.type = type;
	}
	
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect();
		return weatherEffect;
	}
	
	@Override
	public boolean isLand() {
		return (!type.equals(StormType.WHIRLPOOL));			
	}
	
	@Override
	public boolean isWater() {
		return true;
	}
	
	@Override
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	@Override
	public boolean requiresObjectUpdate() {
		return false;
	}
	
	@Override
	public String toString() {		
		return this.type.toString().toLowerCase();
	}
}
