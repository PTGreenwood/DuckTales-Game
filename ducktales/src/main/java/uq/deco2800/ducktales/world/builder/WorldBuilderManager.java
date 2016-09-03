package uq.deco2800.ducktales.world.builder;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.World;

import static uq.deco2800.ducktales.resources.ResourceType.*;

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
    /**
     * CONSTANTS
     */
    public final int TILE = 1;
    public final int ENTITY = 2;


    private World world;
    private WorldBuilderRenderer renderer;
    private ResourceType currentResource = NONE;

    private int currentType = 0;

    /**
     * Returns the instance of {@link WorldBuilderManager}.
     *
     * @return Returns the instance of WorldBuilderManager
     */
    public static WorldBuilderManager getInstance() { return INSTANCE; }

    /**
     * Constructor of the {@link WorldBuilderManager} class
     */
    private WorldBuilderManager() {
    }

    /**
     * Return the current type of resource being managed. Can either
     * be WorldBuilderManager.TILE or WorldBuilderManager.ENTITY,
     * or 0 if nothing has been selected
     *
     * @return the integer value represent the type of resource being managed
     */
    public int getCurrentType() {
        return this.currentType;
    }

    /**
     * Register the rendering engine for the world builder
     * @param renderer
     *          The rendering engine
     */
    public void setRenderer(WorldBuilderRenderer renderer) {
        this.renderer = renderer;
        renderer.start();
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

    /**
     * Get the current resource currently managed by the user
     * @return the type of resource currently managed by the user
     */
    public ResourceType getCurrentResource() {
        return currentResource;
    }

    /**
     * Register the resource being managed by the user
     * @param resource
     *          The type of resource that is being managed
     */
    public void setCurrentResource(ResourceType resource, int type) {
        currentResource = resource;
        currentType = type;
        if (type == this.TILE) {
            renderer.setCurrentTileSelected(resource);
        } else if (type == this.ENTITY) {
            renderer.setCurrentEntitySelected(resource);
        }

        System.out.println("Current resource is: " + resource.toString());
    }


}
