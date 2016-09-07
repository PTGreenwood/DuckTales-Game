package uq.deco2800.ducktales.core;

/**
 * <p>
 *     This class is responsible for controlling GUI logic - it will  have a
 *     handle on all secondary managers, and thus make sure the GUI is updated
 *     appropriately as the game state changes
 * </p>
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class GameManager {
    /**
     * CONSTANTS
     */


    /** The model of the game */
    private World world;

    public GameManager() {
        // Instantiate an empty game manager without a pre-loaded world

        // Create a completely new world
        setupWorld();
    }

    /**
     * Instantiate a Game Manager with the given world
     * @param world
     *          The world to be loaded into the game
     */
    public GameManager(World world) {
        this.world = world;
    }


    private void setupWorld() {
        // Create a new world model for the game

    }
}
