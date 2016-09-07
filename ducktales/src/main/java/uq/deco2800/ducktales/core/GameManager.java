package uq.deco2800.ducktales.core;

import uq.deco2800.ducktales.resources.ResourceType;

import static uq.deco2800.ducktales.resources.ResourceType.*;

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
    private static final double DEFAULT_SCALE = 0.4;
    private static final int DEFAULT_WORLD_WIDTH = 30;
    private static final int DEFAULT_WORLD_HEIGHT = 30;

    /** Variables to control GUI logic */
    private ResourceType currentResourceManaging;

    /** The model of the game */
    private World world;

    public GameManager() {
        // Instantiate an empty game manager without a pre-loaded world.
        // Setup initial variables
        currentResourceManaging = NONE;

        // Create a new world model for the game
        world = new World(
                "New World",
                DEFAULT_WORLD_WIDTH,
                DEFAULT_WORLD_HEIGHT
        );
    }

    /**
     * Instantiate a Game Manager with the given world
     * @param world
     *          The world to be loaded into the game
     */
    public GameManager(World world) {
        this.world = world;
    }

    /**
     * Get the type of the resource being managed. For example, a building
     * that the player is trying to add to the game world
     *
     * @return the type of the resource currently being managed
     */
    public ResourceType getCurrentResourceManaging() {
        return currentResourceManaging;
    }

    /**
     * Set the current resource being managed
     *
     * @param currentResourceManaging
     */
    public void setCurrentResourceManaging(ResourceType currentResourceManaging) {
        this.currentResourceManaging = currentResourceManaging;
    }

    /**
     * Return the current game world, which contains all the information about
     * the current game being played
     *
     * @return the current world of the game
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Set the world for the current game
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
    }
}
