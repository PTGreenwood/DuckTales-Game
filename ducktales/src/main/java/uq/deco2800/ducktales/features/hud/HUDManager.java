package uq.deco2800.ducktales.features.hud;


import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;

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
public class HUDManager {
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
        menuManager = new MenuManager(this.bottomPane);

    }

    /**
     * Load the menus into the HUD
     */
    private void loadMenus() {
    }


}
