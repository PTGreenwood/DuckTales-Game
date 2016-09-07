package uq.deco2800.ducktales.core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>
 *     This is the master controller for the actual game play, while
 *     DuckTalesController controls the main menu and switches between
 *     different views.
 * </p>
 * <p>
 *     GameController is responsible for <b>setting up</b> the game by loading FXML
 *     files and retrieving their controllers in order to pass them to OldGameManager.
 *     It is not responsible for any game logic
 * </p>
 * <p>
 *     This controller is instantiated by FXMLLoader, and retrieved in
 *     DuckTalesController
 * </p>
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class GameController implements Initializable{
    /** UI Elements loaded from FXML */
    @FXML
    private AnchorPane rootPane, leftPane, bottomPane, worldPane;

    /** The Primary Manager of the game, that manages game GUI logic */
    private GameManager gameManager;


    /**
     * This method will be called when this controller is initialized by FXMLLoader
     * in DuckTalesController
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create the Game Manager, which will start the game model
        // Note: in the future, to load a game, just pass a World object to constructor
        gameManager = new GameManager(); // = new GameManager(loadedWorld) for later

        System.err.println("GameController Initialized");
    }
}
