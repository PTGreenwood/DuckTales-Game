package uq.deco2800.ducktales.features.time;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.Tickable;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * This manager controls the time display by retrieving time info from GameTime
 *
 * Created on 9/09/2016.
 * @author khoiphan21
 */
public class TimeManager implements SecondaryManager, Initializable, Tickable {

    /** The root pane for all the time display elements */
    @FXML
    private HBox timeDisplay;
    @FXML
    private Label timeDisplayText;

    /** The model for the game time */
    private GameTime gameTime;

    /**
     * This method is called when GameController initializes the time display using
     * FXMLLoader, and so FXMLLoader will make an instance of this class and call
     * initialized()
     *
     * @param location
     *          The location of this class
     * @param resources
     *          The resources passed to FXMLLoader
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Start the game time
        gameTime = new GameTime();
    }


    @Override
    public void reload() {

    }


    @Override
    public void tick() {
        gameTime.tick();
    }
}
