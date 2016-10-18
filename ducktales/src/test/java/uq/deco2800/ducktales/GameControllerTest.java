package uq.deco2800.ducktales;

import javafx.fxml.FXMLLoader;
import org.junit.Test;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created on 18/10/2016.
 */
public class GameControllerTest extends TestClassWithApplication{
    /** Where the main UI file should be */
    private final String FXML_LOCATION = "/ui/main/mainUI.fxml";

    @Test(expected = GameSetupException.class)
    public void testInvalidFxmlFileLocation() throws IOException{
        initializeGameController("not_a_location");
    }

    @Test(expected = ClassCastException.class)
    public void testWrongFxmlFile() throws IOException{
        initializeGameController("/ducktales.fxml"); // Just a random fxml
    }

    @Test
    public void testGameControllerInstantiation() throws IOException{
        GameController gameController = initializeGameController(FXML_LOCATION);

        assertNotNull(gameController);
    }

    /**
     * Method to instantiate a game controller for testing
     *
     * @return a new instance of the game controller
     *
     * @throws IOException
     *          If the FXML Loader fails to load the fxml file
     */
    private GameController initializeGameController(String fxmlFileLocation)
            throws IOException {
        URL location = getClass().getResource(fxmlFileLocation);
        FXMLLoader loader = new FXMLLoader(location);

        // Load the UI with the controller
        try {
            loader.load();
        } catch (IOException e) {
            throw new IOException("failed to load mainUI with GameController");
        } catch (IllegalStateException e) {
            throw new GameSetupException("location for fxml file is wrong");
        }

        return loader.getController();
    }
}
