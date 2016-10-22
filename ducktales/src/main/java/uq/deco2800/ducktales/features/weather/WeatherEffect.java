package uq.deco2800.ducktales.features.weather;

/**
 * This class is deprecated as WeatherEffects are now drawn by the canvas, this
 * class could be turned into different canvas effects but at this stage this
 * class is no longer required. Updated: 22 October 2016.
 * 
 * Sprites for Weather Effects.
 * 
 * @author mattyleggy
 *
 */
//@Deprecated - add this back in later.
public class WeatherEffect {
	// name of the sprite
	private String name;
	// location of the sprite
	private static final String LOCATION = "weather/";
	// sprite file name
	private String fileName;

	/**
	 * @param name
	 *            name of the sprite
	 * @param location
	 *            folder location of the sprite
	 * @param fileName
	 *            the filename of the sprite.
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
	 * @return the file name of the weather effect
	 */
	public String getFileName() {
		return this.fileName;
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
