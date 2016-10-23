package uq.deco2800.ducktales.features.weather;

/**
 * 
 * InvalidWeatherChanceException is a custom exception to be thrown when an
 * incorrect value is passed for the chance.
 * 
 * @author mattyleggy
 *
 */
@SuppressWarnings("serial")
public class InvalidWeatherChanceException extends Exception {
	public InvalidWeatherChanceException(String s) {
		super(s);
	}
}
