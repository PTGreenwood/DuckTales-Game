package uq.deco2800.ducktales.weather;

public class Rain implements Weather {
	public WeatherEffect getWeatherEffect() {
		WeatherEffect weatherEffect = new WeatherEffect("rain","rain.png");		
		return weatherEffect;
	}
	
	public boolean isLand() {
		return true;
	}
	
	public boolean isWater() {
		return true;
	}
	
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return true;
	}
}
