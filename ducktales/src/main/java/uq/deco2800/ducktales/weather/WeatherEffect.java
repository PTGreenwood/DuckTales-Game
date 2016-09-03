package uq.deco2800.ducktales.weather;

/**
 * Sprites for Weather Effects.
 * 
 * @author mattyleggy
 *
 */
public class WeatherEffect {
	//name of the sprite
	private String name;
	//location of the sprite
	private static final String LOCATION = "weather/";
	//sprite file name
	private String fileName;
	
	public WeatherEffect() {
		//need to remove this one.
	}
		
	/**
	 * @param name
	 * 			name of the sprite
	 * @param location
	 * 			folder location of the sprite
	 * @param fileName
	 * 			the filename of the sprite.
	 */
	public WeatherEffect(String fileName) {				
		this.fileName = fileName;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return weather effect name
	 */
	public String getName() {
		return this.name;
	}

	
	/**
	 * Get the location that the sprite is located
	 * 
	 * @return sprite location
	 */
	public String getLocation() {
		return LOCATION;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Get the the sprite of the weather effect.
	 * 
	 * @return the weather effect sprite
	 */
	public String getSprite() {
		return LOCATION + this.fileName;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
