package uq.deco2800.ducktales.features.weather;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.util.SecondaryManager;

import java.io.IOException;
import java.net.URL;

/**
 * This class manages all the UI components of the HUD for the game
 * such as controlling when and where to display the cursor image, and changing the HUD
 * UI elements along the way as appropriate
 *
 * TODO: MOVE THIS CLASS TO FXML LOADER IMPLEMENTATION AS HUD GETS MORE COMPLICATED
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class WeatherManager implements SecondaryManager {

    /**
     * Creates a manager for the HUD. Setup the HUD by instantiating helper managers
     */
    public WeatherManager(AnchorPane rootPane, AnchorPane leftPane, AnchorPane bottomPane) {
       
    }



    @Override
    public void reload() {

    }
}
