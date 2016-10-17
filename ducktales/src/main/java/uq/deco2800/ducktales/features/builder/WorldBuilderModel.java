package uq.deco2800.ducktales.features.builder;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.World;

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
 * Modified by Gabrielle Hodge, 18/9/2016. To convert to MVC
 */
public class WorldBuilderModel {	
    private static final WorldBuilderModel INSTANCE = new WorldBuilderModel();
    /**
     * CONSTANTS
     */
    protected static final int TILE = 1;
    protected static final int ENTITY = 2;


    private World world;
    
    private ResourceType currentResource = NONE;

    private int currentType = 0;

    public static WorldBuilderModel getInstance() { return INSTANCE; }
    
    /**
     * Constructor of the {@link WorldBuilderModel} class
     */
    private WorldBuilderModel() {
    }

    /**
     * Return the current type of resource being managed. Can either
     * be WorldBuilderManager.TILE or WorldBuilderManager.ENTITY,
     * or 0 if nothing has been selected
     *
     * @return the integer value represent the type of resource being managed
     */
    protected int getCurrentType() {
        return this.currentType;
    }

    /**
     * Sets the world to be edited
     *
     * @param world
     *          The world to be edited
     */
    protected void setWorld(World world) {
        this.world = world;
    }

    /**
     * Get the world for this canvas
     * @return the world of the WorldBuilder canvas
     */
    protected World getWorld() { 
    	return world; 
    }

    /**
     * Get the current resource currently managed by the user
     * @return the type of resource currently managed by the user
     */
    protected ResourceType getCurrentResource() {
        return currentResource;
    }

    /**
     * Register the resource being managed by the user
     * @param resource
     *          The type of resource that is being managed
     */
    protected Object[] setCurrentResource(ResourceType resource, int type) {
        currentResource = resource;
        currentType = type;
        String name = "";
        if (type == TILE) {
           name = "tile";
        } else if (type == ENTITY) {
            name = "entity";
        }
        return new Object[] {name, resource};
    }
}
