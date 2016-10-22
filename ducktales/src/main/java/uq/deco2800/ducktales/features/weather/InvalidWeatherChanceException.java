package uq.deco2800.ducktales.features.weather;

/**
 * @author mattyleggy
 *
 */
@SuppressWarnings("serial")
public class InvalidWeatherChanceException extends Exception {
    public InvalidWeatherChanceException(String s) {
        super(s);
    }
}
