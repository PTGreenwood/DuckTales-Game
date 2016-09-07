package uq.deco2800.ducktales.features.hud;


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
public class HUDManager implements SecondaryManager {
    /** the root pane to add all panes into */
    private AnchorPane rootPane;
    /** FXML variables - this implementation should be changed later to use FXML */
    private AnchorPane bottomPane;

    /** Helper managers */
    private MenuManager menuManager;

    /**
     * Creates a manager for the HUD. Setup the HUD by instantiating helper managers
     */
    public HUDManager(AnchorPane rootPane, AnchorPane bottomPane) {
        this.rootPane = rootPane;
        this.bottomPane = bottomPane;

        // Instantiates the helper managers
        loadMenus();
    }

    /**
     * Load the menus into the HUD
     */
    private void loadMenus() {
        URL location = getClass().getResource("/ui/hud/menu.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        // Load the FXML file and get the controller
        try {
            AnchorPane menuPane = loader.load();
            menuManager = loader.getController();

            // Add and style the menu pane to the bottom pane
            bottomPane.getChildren().add(menuPane);
            bottomPane.setBottomAnchor(menuPane, 0.0);
            bottomPane.setLeftAnchor(menuPane, 0.0);
            bottomPane.setRightAnchor(menuPane, 0.0);
            bottomPane.setTopAnchor(menuPane, 0.0);
        } catch (IOException e) {
            System.err.println("unable to load menu");
            e.printStackTrace();
        }
    }

    @Override
    public void reload() {

    }
}
