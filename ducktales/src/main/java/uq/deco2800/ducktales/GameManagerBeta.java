package uq.deco2800.ducktales;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.WorldBeta;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameManagerBeta {

    /** The game world */
    private WorldBeta world;

    /** The rendering engine */
    private GameRendererBeta renderer;

    /**
     * Variables for managing the game
     */
    // The thing the player currently wants to add to the world, eg. building
    private ResourceType currentResourceManaging = NONE;

    /**
     * Constructor of the {@link GameManagerBeta} class
     */
    public GameManagerBeta() {
        // Stub constructor
    }

    /**
     * Officially start the game
     */
    public void startGame() {
        if (world == null) {
            // No world has been pre-loaded. Start a default world

        }

        // Start the rendering engine
        this.renderer.start();

    }

    /**
     * Set the
     * @param renderer
     */
    public void setRenderer (GameRendererBeta renderer) {
        this.renderer = renderer;
    }

    /**
     * Set the world for the current game
     *
     * @param world
     */
    public void setWorld(WorldBeta world) {
        this.world = world;
    }

    /**
     * Return the current game world, which contains all the information about
     * the current game being played
     *
     * @return the current world of the game
     */
    public WorldBeta getWorld() {
        return this.world;
    }

    /**
     * Notify itself that a building sprite in the buildings menu has been clicked
     *
     * @param buildingType
     *          The type of building in the buildings menu clicked
     */
    public void notifyBuildingMenuClicked(ResourceType buildingType) {

    }
}
