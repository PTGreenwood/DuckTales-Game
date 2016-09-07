package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.resources.ResourceType;
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

    /** The main model of the game */
    private World world;

    /** Helper managers */
    private TilesManager tilesManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * This method is called by Game Manager when all managers have been set up,
     * which will render the initial world onto the display
     */
    public void initializeWorld() {
        // Instantiate the helper managers
        tilesManager = new TilesManager(this.world, this.rootPane);

        // render the tiles
        tilesManager.renderInitialWorld();

    }

    /**
     * Pass a handle of the game world to this manager
     *
     * @param world
     *          The game world
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Get the tiles manager
     *
     * @return the tiles manager
     */
    public TilesManager getTilesManager() {
        return this.tilesManager;
    }

    @Override
    public void reload() {

    }
}
