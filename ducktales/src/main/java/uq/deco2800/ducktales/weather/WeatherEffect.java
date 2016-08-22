package uq.deco2800.ducktales.weather;

/**
 * Weather sprites and effects
 * 
 * @author mattyleggy
 *
 */
public class WeatherEffect {
	private String name;
	private String location;	
	public WeatherEffect() {
		//need to remove this one.
	}
	
	public WeatherEffect(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}
}
