package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.util.SecondaryManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the manager for the display of the world - where the player can see
 * and interact with the actual game world
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class WorldDisplayManager implements Initializable, SecondaryManager {
    /** The root pane where all world objects will be added to */
    @FXML
    private Pane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void reload() {

    }
}
