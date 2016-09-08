package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayRenderer.*;

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

    /** The main manager of the game */
    private GameManager gameManager;

    /** Helper managers */
    private TilesManager tilesManager;

    /** The rendering engine for the world display */
    private WorldDisplayRenderer renderer;

    /** The directions to move the world */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create and start the renderer
        renderer = new WorldDisplayRenderer();
        renderer.start();

    }

    @Override
    public void reload() {

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

        // Load the rendering engine
        renderer.setTilesManager(tilesManager);

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
     * Pass the handle of the game manager to this manager
     *
     * @param gameManager
     *
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Get the tiles manager
     *
     * @return the tiles manager
     */
    public TilesManager getTilesManager() {
        return this.tilesManager;
    }

    /**
     * Move the whole world in the given direction
     *
     * @param direction
     *          The direction to move the whole world towards
     */
    public void moveWorld(Direction direction) {
        switch (direction) {
            case UP:
                renderer.setMovingDirectionV(VDirection.UP);
                break;
            case DOWN:
                renderer.setMovingDirectionV(VDirection.DOWN);
                break;
            case LEFT:
                renderer.setMovingDirectionH(HDirection.LEFT);
                break;
            case RIGHT:
                renderer.setMovingDirectionH(HDirection.RIGHT);
                break;
        }
    }

    /**
     * Stop moving the world in the given direction
     *
     * @param direction
     *          The direction that the world should stop moving towards
     */
    public void stopMoveWorld(Direction direction) {
        switch (direction) {
            case UP:case DOWN:
                renderer.setMovingDirectionV(VDirection.NONE);
                break;
            case LEFT:case RIGHT:
                renderer.setMovingDirectionH(HDirection.NONE);
                break;
        }
    }
}
