package uq.deco2800.ducktales.world.builder;

import uq.deco2800.ducktales.world.World;

/**
 * Manage the interaction between the user and the World Builder
 * This method will create a new world where there is no entities in it at first
 *
 * The tiles will be set to the most basic tile type for all tiles
 *
 * Entities can be added on later in future implementations
 *
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderManager {
    private static final WorldBuilderManager INSTANCE = new WorldBuilderManager();

    private World world;


    /**
     * Returns the instance of {@link WorldBuilderManager}.
     *
     * @return Returns the instance of WorldBuilderManager
     */
    public static WorldBuilderManager getInstance() { return INSTANCE; }

    /**
     * Constructor of the WorldBuilderManager class
     */
    private WorldBuilderManager() {
        // stub method
    }

    /**
     * Sets the world to be edited
     *
     * @param world
     *          The world to be edited
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Get the world for this canvas
     * @return the world of the WorldBuilder canvas
     */
    public World getWorld() { return world; };



}
