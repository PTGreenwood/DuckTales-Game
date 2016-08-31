package uq.deco2800.ducktales;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.World;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameManagerBeta {

    /** The global variables in the game */
    private World world;
    private GameRendererBeta renderer;

    /**
     * Variables for managing the game
     */
    // The thing the player currently wants to add to the world, eg. building
    private ResourceType currentResourceManaging = NONE;

    private static GameManagerBeta ourInstance = new GameManagerBeta();

    public static GameManagerBeta getInstance() {
        return ourInstance;
    }

    /**
     * Constructor of the {@link GameManagerBeta} class
     */
    private GameManagerBeta() {


    }

    /**
     * Set the
     * @param renderer
     */
    public void setRenderer (GameRendererBeta renderer) {
        this.renderer = renderer;
        this.renderer.start();
    }

    /**
     * Set the world for the current game
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
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
     * Notify itself that a building sprite in the buildings menu has been clicked
     *
     * @param buildingType
     *          The type of building in the buildings menu clicked
     */
    public void notifyBuildingMenuClicked(ResourceType buildingType) {

    }
}
