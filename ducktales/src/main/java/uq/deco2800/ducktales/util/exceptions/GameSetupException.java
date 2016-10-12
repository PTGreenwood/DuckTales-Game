package uq.deco2800.ducktales.util.exceptions;

/**
 * This is an exception raised whenever the game is not set up properly
 * before it is run
 *
 * Created on 12/10/2016.
 * @author khoiphan21
 */
public class GameSetupException extends RuntimeException {
    public GameSetupException(String message) {
        super(message);
    }
}
