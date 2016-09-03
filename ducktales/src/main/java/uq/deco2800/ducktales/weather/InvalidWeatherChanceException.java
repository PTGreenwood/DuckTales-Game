package uq.deco2800.ducktales.weather;

/**
 * @author mattyleggy
 *
 */
@SuppressWarnings("serial")
public class InvalidWeatherChanceException extends Exception {
	public InvalidWeatherChanceException() {
        super();
    }

    public InvalidWeatherChanceException(String s) {
        super(s);
    }
}
